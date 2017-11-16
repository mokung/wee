package me.wenkang.wee.dao.struct.entity.user;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private String userName;

    private String nickName;

    private String password;

    private String avatar;

    private String signature;

    private String introduction;

    private Integer isValid;

    private Integer isDelete;

    private Date createdAt;

    private String createBy;

    private Date updatedAt;

    private String modifyBy;
}