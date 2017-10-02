package com.wenkang.wee.biz.user;

import com.wenkang.wee.api.common.struct.ResponseData;
import com.wenkang.wee.api.service.user.UserService;
import com.wenkang.wee.biz.struct.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by wenkang
 * on 2017/9/1.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Override
    public ResponseData getUserById(Long id) {
        log.info("wwwww");
        return new ResponseData(ReturnCode.SUCCESS,"wwwww");
    }
}
