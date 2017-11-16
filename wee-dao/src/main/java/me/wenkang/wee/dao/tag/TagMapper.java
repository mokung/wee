package me.wenkang.wee.dao.tag;

import me.wenkang.wee.dao.struct.entity.tag.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}