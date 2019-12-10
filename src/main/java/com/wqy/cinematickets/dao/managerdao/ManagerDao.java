package com.wqy.cinematickets.dao.managerdao;

import com.wqy.cinematickets.entity.User;

public interface ManagerDao {
    //根据用户名和密码查询用户是否存在
    int isUser(User u);
    //根据用户名和密码查询用户信息
   User getUserByNameAndPassword(User u);
}
