package me.wenkang.wee.dao.tag;

import me.wenkang.wee.dao.struct.entity.tag.TagArticle;

public interface TagArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TagArticle record);

    int insertSelective(TagArticle record);

    TagArticle selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TagArticle record);

    int updateByPrimaryKey(TagArticle record);
}