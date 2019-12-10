package com.wqy.cinematickets.service.managerservice;

import com.wqy.cinematickets.entity.User;

public interface ManagerService {
    //根据用户名和密码查询用户是否存在
    Boolean isUser(User user);
    //根据用户名和密码查询用户信息
    User getUserByNameAndPassword(User u);
}
