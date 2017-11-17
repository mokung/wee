package me.wenkang.wee.controller.admin.user;

import me.wenkang.wee.api.common.struct.ResponseData;
import me.wenkang.wee.api.common.struct.entity.user.UserQuery;
import me.wenkang.wee.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wenkang
 * @since 2017/11/16
 */
@RestController
@RequestMapping(value = "/admin/user")
public class UserManagementController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/query")
    private ResponseData query(HttpServletRequest request, @RequestBody
            UserQuery query){
        return userService.query(query);
    }
}
