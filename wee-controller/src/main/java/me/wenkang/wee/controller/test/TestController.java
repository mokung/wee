package me.wenkang.wee.controller.test;

import me.wenkang.wee.api.common.struct.ResponseData;
import me.wenkang.wee.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wenkang
 * on 2017/11/13.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    public ResponseData test(Long id){
        return userService.getUserById(id);
    }

}
