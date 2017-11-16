package me.wenkang.wee.dao.user;

import me.wenkang.wee.dao.struct.entity.user.UserAdmin;

public interface UserAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAdmin record);

    int insertSelective(UserAdmin record);

    UserAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAdmin record);

    int updateByPrimaryKey(UserAdmin record);
}