package com.wqy.cinematickets.service.managerservice.impl;

import com.wqy.cinematickets.dao.managerdao.ManagerDao;
import com.wqy.cinematickets.entity.User;
import com.wqy.cinematickets.service.managerservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    //根据用户名和密码查询用户是否存在
    public Boolean isUser(User user){
        int isU=managerDao.isUser(user);
        if (isU > 0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    //根据用户名和密码查询用户信息
    public User getUserByNameAndPassword(User u){
        return managerDao.getUserByNameAndPassword(u);
    }
}
