package me.wenkang.wee.api.service.user;

import me.wenkang.wee.api.common.struct.ResponseData;
import me.wenkang.wee.api.common.struct.entity.user.UserQuery;
import me.wenkang.wee.api.common.struct.entity.user.UserVo;

/**
 * Created by wenkang
 * on 2017/9/1.
 */
public interface UserService {

    ResponseData getUserById(Long id);

    /**
     * 注册
     * @param userVo
     * @return
     */
    ResponseData register(UserVo userVo);

    /**
     * 登录
     * @param userVo
     * @return
     */
    ResponseData login(UserVo userVo);


    /**
     * 登出
     * @param token
     * @return
     */
    ResponseData logout(String token);
    /**
     * 分页查询
     * @param query
     * @return
     */
    ResponseData query(UserQuery query);
}
