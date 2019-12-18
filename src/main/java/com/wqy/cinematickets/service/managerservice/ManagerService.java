package com.wqy.cinematickets.service.managerservice;

import com.wqy.cinematickets.entity.*;

import java.util.List;

public interface ManagerService {
    //根据用户名和密码查询用户是否存在
    Boolean isUser(User user);
    //根据用户名和密码查询用户信息
    User getUserByNameAndPassword(User u);
    //插入影片
    Boolean addMovie(Film film);
    //查询所有影片
    List<Film> getAllMovie();
    //分页查询影片库
    List<Film> getMoviePagination(Pagination pagination);
    //查询影片库数量
    int getAllMovieCount();
    //修改影片库的影片信息
    Boolean updateMovieById(Film film);
    //根据影片id删除影片库的影片
    Boolean delMovieByid(int id);
    //根据电影名字影片库模糊查询
    List<Film> getMovieByName(Pagination pagination);
    //根据电影名字影片库模糊查询的数据个数
    int getMovieByNameCount(String name);
    //添加近期影片
    Boolean addRecentFilms(int mid);
    //根据影片id删除近期影片
    Boolean delRecentFilmsById(int mid);
    //获取近期影片
    List<Film> getAllRecentFilms();
    //添加放映厅
    Boolean addProjectionHall(ProjectionHall projectionHall);
    //修改放映厅
    Boolean updateProjectionHallById(ProjectionHall projectionHall);
    //获取所有放映厅
    List<ProjectionHall> getAllProjectionHall();
    //删除放映厅
    Boolean delProjectionHallById(int pid);
    //添加场次安排
    Boolean addExclusivePiece(ExclusivePiece exclusivePiece);
    //单表查询场次
    List<ExclusivePiece> getExclusivepiece();
    //多表获取排片信息
    List<ExclusivePiece> getExclusivepieceInfo(Pagination pagination);
    //获取场次数量
    int getExclusivepieceCount();
    //根据电影名字对场次安排模糊查询
    List<ExclusivePiece> gettExclusivepieceByName(Pagination pagination);
    //获取电影名模糊查询场次的数量
    int getExclusivepieceByNameCount(String name);
    //删除场次
    Boolean delExclusivepieceById(int eid);
}
