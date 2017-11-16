package me.wenkang.wee.dao.struct.entity.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserAdmin {
    private Long id;

    private Long userId;

    private Integer isDelete;

    private Date createdAt;

    private String createBy;

    private Date updatedAt;

    private String modifyBy;

}