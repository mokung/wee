package me.wenkang.wee.controller.user;

import me.wenkang.wee.api.common.struct.ResponseData;
import me.wenkang.wee.api.common.struct.entity.user.UserVo;
import me.wenkang.wee.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wenkang
 * on 2017/11/14.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    private ResponseData register(@RequestBody UserVo userVo){
        return userService.register(userVo);
    }

    @RequestMapping(value = "/login")
    private ResponseData login(HttpServletRequest request, @RequestBody UserVo userVo){
        userVo.setIpAddress(request.getRemoteAddr());
        return userService.login(userVo);
    }

    @RequestMapping(value = "/logout")
    private ResponseData logout(HttpServletRequest request){
        String token = request.getHeader("Authentication");
        return userService.logout(token);
    }

}
