package me.wenkang.wee.biz.user;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import me.wenkang.wee.api.common.struct.ResponseData;
import me.wenkang.wee.api.common.struct.entity.user.UserVo;
import me.wenkang.wee.api.service.user.UserService;
import me.wenkang.wee.biz.struct.ReturnCode;
import me.wenkang.wee.biz.utils.MD5Util;
import me.wenkang.wee.biz.utils.RedisUtils;
import me.wenkang.wee.dao.struct.entity.user.User;
import me.wenkang.wee.dao.user.UserMapper;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.validation.Valid;

/**
 * Created by wenkang
 * on 2017/9/1.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseData getUserById(Long id) {
        log.info(id.toString());
        User user = userMapper.selectByPrimaryKey(id);
        return new ResponseData(ReturnCode.SUCCESS, user);
    }

    @Override
    public ResponseData register(UserVo userVo) {
        log.info("register入参{}", userVo);
        Assert.notNull(userVo);
        userVo.setId(null);
        User user = userMapper.getByUserName(userVo.getUserName());
        if (user!=null){
            return new ResponseData(ReturnCode.USERNAME_EXISTS);
        }
        user = new User();
        BeanUtils.copyProperties(userVo, user);

        if (StringUtils.isEmpty(user.getNickName())) {
            user.setNickName("用户" + RandomUtils.nextInt(1000000, 9999999));
        }
        String password = MD5Util.encrypt(user.getPassword());
        if (StringUtils.isEmpty(password)){
            return new ResponseData(ReturnCode.SYS_EXCEPTION);
        }
        user.setPassword(password);
        user.setCreateBy("register");
        user.setModifyBy("register");
        userMapper.insertSelective(user);
        return new ResponseData(ReturnCode.SUCCESS);
    }

    @Override
    @Valid
    public ResponseData login(UserVo userVo) {
        String password = MD5Util.encrypt(userVo.getPassword());
        User user = userMapper.getByUserName(userVo.getUserName());
        if (user == null || user.getIsDelete() == 1 || !user.getPassword().equals(password)) {
            return new ResponseData(ReturnCode.USERNAME_OR_PASSWD_ERROR);
        }
        String token = (Long.toHexString(System.currentTimeMillis()) + Long.toHexString(user.getId()) + Long
                .toHexString(user.getId() * RandomUtils.nextInt(1, 9) + RandomUtils.nextInt(10, 99999))).toUpperCase();

        RedisUtils.accept(jedis -> jedis.set(token, JSONObject.toJSONString(user)));
        RedisUtils.accept(jedis -> jedis.expire(token, 60 * 60 * 24 * 10));
        JSONObject object = new JSONObject();
        object.put("token", token);
        log.info("token:{}", token);
        // TODO 登录日志
        return new ResponseData(ReturnCode.SUCCESS, object);
    }

    @Override
    public ResponseData logout(String token) {
        RedisUtils.accept(jedis -> jedis.del(token));
        return new ResponseData(ReturnCode.SUCCESS);
    }
}
