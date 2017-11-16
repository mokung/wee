package me.wenkang.wee.dao.article;

import me.wenkang.wee.dao.struct.entity.article.ArticleComment;

public interface ArticleCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    ArticleComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
}