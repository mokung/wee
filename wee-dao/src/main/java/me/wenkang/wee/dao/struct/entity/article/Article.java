package me.wenkang.wee.dao.struct.entity.article;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Long id;

    private String title;

    private String summary;

    private Integer isDelete;

    private Date createdAt;

    private String createBy;

    private Date updatedAt;

    private String modifyBy;

    private String content;
}