package me.wenkang.wee.components.page;

import lombok.extern.slf4j.Slf4j;
import me.wenkang.wee.components.constant.page.Pager;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author wenkang
 * @since 2017/11/16
 */
@Slf4j
@Component
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class PageInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        if (invocation.getTarget() instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            Object obj = boundSql.getParameterObject();

            if (obj instanceof Pager && ((Pager) obj).isNeedPage()) {
                ParameterHandler parameterHandler = statementHandler.getParameterHandler();

                // 分页参数作为参数对象parameterObject的一个属性
                String sql = boundSql.getSql();
                Pager pager = (Pager) obj;

                // 重写sql
                String countSql = concatCountSql(sql);
                String pageSql = concatPageSql(sql, pager);

                Connection connection = (Connection) invocation.getArgs()[0];

                PreparedStatement countStmt = null;
                ResultSet rs = null;
                int totalCount = 0;
                try {
                    countStmt = connection.prepareStatement(countSql);
                    parameterHandler.setParameters(countStmt);
                    rs = countStmt.executeQuery();
                    if (rs != null && rs.next()) {
                        totalCount = rs.getInt(1);
                    }
                } catch (SQLException e) {
                    log.error("分页异常", e);
                    log.info("count  sql :{}", countSql);
                    log.info("select  sql :{}", pageSql);
                    throw e;
                } finally {

                    if (rs != null) {
                        rs.close();
                    }
                    if (countStmt != null) {
                        countStmt.close();
                    }
                }
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
                pager.setTotal(totalCount);
            }

        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        if (o instanceof StatementHandler) {
            return Plugin.wrap(o, this);
        } else {
            return o;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private String concatCountSql(String sql) throws SQLException {
        StringBuilder sb = new StringBuilder("select count(1) ");
        sql = sql.toLowerCase();

        sql = sql.replaceAll("\\n","");
        int left = 0;
        int right = 0;
        int index = -1;
        //以from切割sql语句，替换第一个不在括号内的from之前的语句

        String[] strings = sql.split("from");
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            left+= StringUtils.countOccurrencesOf(str,"(");
            right+= StringUtils.countOccurrencesOf(str,")");
            if (left==right&&i!=strings.length-1){
                index = i;
                break;
            }
        }

        if (index == -1){
            throw new SQLException("sql解析错误");
        }
        index+=1;
        for (int i = index; i < strings.length; i++) {
            sb.append("from").append(strings[i]);
        }
        return sb.toString();
    }

    private String concatPageSql(String sql, Pager pager) {

        return sql + " limit " + ((pager.getCurPage() - 1) * pager.getPageSize()) + " , " + pager.getPageSize();
    }


}
