package me.wenkang.wee.dao.user;

import me.wenkang.wee.dao.struct.entity.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getByUserName(String userName);
}