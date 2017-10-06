package me.wenkang.wee.api.test;

import me.wenkang.wee.api.common.struct.ResponseData;
import me.wenkang.wee.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenkang
 * on 2017/9/2.
 */

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public ResponseData test(){
        return userService.getUserById(1L);
    }

}
