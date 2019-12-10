package com.wqy.cinematickets.controller.managercontroller;

import com.wqy.cinematickets.entity.Result;
import com.wqy.cinematickets.entity.User;
import com.wqy.cinematickets.service.managerservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    //登录
    @RequestMapping(value = "/manager/getUserByNameAndPassword",method = RequestMethod.POST)
    public Result<User> getUserByNameAndPassword(@RequestBody User u){
        User user=managerService.getUserByNameAndPassword(u);
        Result<User> result=new Result<User>();
        if(user != null){
            result.setCode(0);
            result.setBody(u);
        }else {
            result.setCode(1000);
            result.setMessage("您的账号还未注册");
        }
        return result;
    }


}
