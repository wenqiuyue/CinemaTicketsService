package com.wqy.cinematickets.controller.managercontroller;

import com.wqy.cinematickets.entity.*;
import com.wqy.cinematickets.service.managerservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    //根据电影名字影片库模糊查询
    @RequestMapping(value = "/getMovieByName",method = RequestMethod.POST)
    public Result<List<Film>> getMovieByName(@RequestBody Pagination pagination){
        Result<List<Film>> filmResult = new Result<List<Film>>();
        List<Film> film=managerService.getMovieByName(pagination);
        if(film != null){
            filmResult.setCode(0);
            filmResult.setBody(film);
        }else {
            filmResult.setCode(1000);
            filmResult.setMessage("没有查询到电影数据");
        }
        return filmResult;
    }

    //根据电影名字影片库模糊查询的数据个数
    @RequestMapping(value = "/getMovieByNameCount",method = RequestMethod.GET)
    public int getMovieByNameCount(String name){
        return managerService.getMovieByNameCount(name);
    }

    //添加近期影片
    @RequestMapping(value = "/addRecentFilms",method = RequestMethod.GET)
    public Boolean addRecentFilms(int mid){
        return managerService.addRecentFilms(mid);
    }

    //根据影片id删除近期影片
    @RequestMapping(value = "/delRecentFilmsById",method = RequestMethod.GET)
    public Boolean delRecentFilmsById(int mid){
        return managerService.delRecentFilmsById(mid);
    }

    //获取近期影片
    @RequestMapping(value = "/getAllRecentFilms",method = RequestMethod.GET)
    public Result<List<Film>> getAllRecentFilms(){
        List<Film> film=managerService.getAllRecentFilms();
        Result<List<Film>> filmres=new Result<List<Film>>();
        if(film != null){
            filmres.setCode(0);
            filmres.setBody(film);
        }else {
            filmres.setCode(1000);
            filmres.setMessage("未查询到数据");
        }
        return filmres;
    }

    //添加放映厅
    @RequestMapping(value = "/addProjectionHall",method = RequestMethod.POST)
    public Boolean addProjectionHall(@RequestBody ProjectionHall projectionHall){
        return managerService.addProjectionHall(projectionHall);
    }

    //修改放映厅
    @RequestMapping(value = "/updateProjectionHallById",method = RequestMethod.POST)
    public Boolean updateProjectionHallById(@RequestBody ProjectionHall projectionHall){
        return managerService.updateProjectionHallById(projectionHall);
    }

    //获取所有放映厅
    @RequestMapping(value = "/getAllProjectionHall",method = RequestMethod.GET)
    public Result<List<ProjectionHall>> getAllProjectionHall(){
        List<ProjectionHall> projectionHalls=managerService.getAllProjectionHall();
        Result<List<ProjectionHall>> proResult=new Result<List<ProjectionHall>>();
        if(projectionHalls!=null){
            proResult.setCode(0);
            proResult.setBody(projectionHalls);
        }else {
            proResult.setCode(1000);
            proResult.setMessage("没有查询到数据");
        }
        return proResult;
    }

    //删除放映厅
    @RequestMapping(value = "/delProjectionHallById",method = RequestMethod.GET)
    public Boolean delProjectionHallById(int pid){
        return managerService.delProjectionHallById(pid);
    }


    //添加场次安排
    @RequestMapping(value = "/addExclusivePiece",method = RequestMethod.POST)
    public Boolean addExclusivePiece(@RequestBody ExclusivePiece exclusivePiece){
        System.out.print(exclusivePiece.getTimeend());
        return managerService.addExclusivePiece(exclusivePiece);
    }

    //单表查询场次
    @RequestMapping(value = "/getExclusivepiece",method = RequestMethod.GET)
    public Result<List<ExclusivePiece>> getExclusivepiece(){
        List<ExclusivePiece> exclusivePieceList = managerService.getExclusivepiece();
        Result<List<ExclusivePiece>> listResult = new Result<List<ExclusivePiece>>();
        if(exclusivePieceList!=null){
            listResult.setCode(0);
            listResult.setBody(exclusivePieceList);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //多表获取排片信息
    @RequestMapping(value = "/getExclusivepieceInfo",method = RequestMethod.POST)
    public Result<List<ExclusivePiece>> getExclusivepieceInfo(@RequestBody Pagination pagination){
        List<ExclusivePiece> exclusivePieceList = managerService.getExclusivepieceInfo(pagination);
        Result<List<ExclusivePiece>> listResult = new Result<List<ExclusivePiece>>();
        if(exclusivePieceList!=null){
            listResult.setCode(0);
            listResult.setBody(exclusivePieceList);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //获取场次数量
    @RequestMapping(value = "/getExclusivepieceCount",method = RequestMethod.GET)
    public int getExclusivepieceCount(){
        return managerService.getExclusivepieceCount();
    }

    //根据电影名字对场次安排模糊查询
    @RequestMapping(value = "/gettExclusivepieceByName",method = RequestMethod.POST)
    public Result<List<ExclusivePiece>> gettExclusivepieceByName(@RequestBody Pagination pagination){
        List<ExclusivePiece> exclusivePieceList = managerService.gettExclusivepieceByName(pagination);
        Result<List<ExclusivePiece>> listResult = new Result<List<ExclusivePiece>>();
        if(exclusivePieceList!=null){
            listResult.setCode(0);
            listResult.setBody(exclusivePieceList);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //获取电影名模糊查询场次的数量
    @RequestMapping(value = "/getExclusivepieceByNameCount",method = RequestMethod.GET)
    public int getExclusivepieceByNameCount(String name){
        return managerService.getExclusivepieceByNameCount(name);
    }

    //删除场次
    @RequestMapping(value = "/delExclusivepieceById",method = RequestMethod.GET)
    public Boolean delExclusivepieceById(int eid){
        return managerService.delExclusivepieceById(eid);
    }

}
