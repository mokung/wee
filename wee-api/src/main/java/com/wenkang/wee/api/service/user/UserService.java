package com.wenkang.wee.api.service.user;

import com.wenkang.wee.api.common.struct.ResponseData;

/**
 * Created by wenkang
 * on 2017/9/1.
 */
public interface UserService {

    ResponseData getUserById(Long id);
}
