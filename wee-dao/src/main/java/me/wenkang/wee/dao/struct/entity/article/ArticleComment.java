package me.wenkang.wee.dao.struct.entity.article;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleComment {
    private Long id;

    private Long userId;

    private Long articleId;

    private String content;

    private Integer isDelete;

    private Date createdAt;

    private String createBy;

    private Date updatedAt;

    private String modifyBy;
}