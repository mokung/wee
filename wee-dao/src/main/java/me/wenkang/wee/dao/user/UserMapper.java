package me.wenkang.wee.dao.user;

import me.wenkang.wee.api.common.struct.entity.user.UserQuery;
import me.wenkang.wee.dao.struct.entity.user.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getByUserName(String userName);

    List<User> findPage(UserQuery query);
}