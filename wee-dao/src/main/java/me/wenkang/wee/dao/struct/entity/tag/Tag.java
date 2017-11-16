package me.wenkang.wee.dao.struct.entity.tag;

import lombok.Data;

import java.util.Date;

@Data
public class Tag {
    private Long id;

    private String tagName;

    private Date createdAt;

    private String createBy;

    private Date updatedAt;

    private String modifyBy;

}