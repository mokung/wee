package me.wenkang.wee.api.common.struct.entity.article;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleVo {

    private String title;

    private String summary;

    private String createBy;

    private String modifyBy;

    private String content;
}