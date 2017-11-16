package me.wenkang.wee.dao.struct.entity.tag;

import lombok.Data;

import java.util.Date;

@Data
public class TagArticle {
    private Long id;

    private Long tagId;

    private Long articleId;

    private Date createdAt;

    private String createBy;

    private Date updatedAt;

    private String modifyBy;

}