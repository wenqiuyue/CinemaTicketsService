package com.wqy.cinematickets.controller.managercontroller;

import com.wqy.cinematickets.entity.Film;
import com.wqy.cinematickets.entity.Pagination;
import com.wqy.cinematickets.entity.Result;
import com.wqy.cinematickets.entity.User;
import com.wqy.cinematickets.service.managerservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    //登录
    @RequestMapping(value = "/getUserByNameAndPassword",method = RequestMethod.POST)
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

    //插入影片
    @RequestMapping(value = "/addMovie",method = RequestMethod.POST)
    public Boolean addMovie(@RequestBody Film film){
        return managerService.addMovie(film);
    }

    //接收图片
    @RequestMapping(value = "/getPic")
    public String getPic(HttpServletRequest request, MultipartFile file){
        return "1";
    }

    //查询所有影片
    @RequestMapping(value = "/getAllMovie",method = RequestMethod.GET)
    public Result<List<Film>> getAllMovie(){
        Result<List<Film>> filmResult = new Result<List<Film>>();
        List<Film> film1= managerService.getAllMovie();
        if(film1 != null){
            filmResult.setCode(0);
            filmResult.setBody(film1);
        }else {
            filmResult.setCode(1000);
            filmResult.setMessage("没有查询到电影数据");
        }
        return filmResult;
    }

    //分页查询影片库
    @RequestMapping(value = "/getMoviePagination",method = RequestMethod.POST)
    public Result<List<Film>> getMoviePagination(@RequestBody Pagination pagination){
        Result<List<Film>> filmResult = new Result<List<Film>>();
        List<Film> film1= managerService.getMoviePagination(pagination);
        if(film1 != null){
            filmResult.setCode(0);
            filmResult.setBody(film1);
        }else {
            filmResult.setCode(1000);
            filmResult.setMessage("没有查询到电影数据");
        }
        return filmResult;
    }

    //查询影片库数量
    @RequestMapping(value = "/getAllMovieCount",method = RequestMethod.GET)
    public int getAllMovieCount(){
        return managerService.getAllMovieCount();
    }

    //修改影片库的影片信息
    @RequestMapping(value = "/updateMovieById",method = RequestMethod.POST)
    public Boolean updateMovieById(@RequestBody Film film){
        return managerService.updateMovieById(film);
    }

    //根据影片id删除影片库的影片
    @RequestMapping(value = "/delMovieByid",method = RequestMethod.GET)
    public Boolean delMovieByid(Integer mid){
        return managerService.delMovieByid(mid);
    }

}
