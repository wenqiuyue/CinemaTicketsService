package com.wqy.cinematickets.dao.managerdao;

import com.wqy.cinematickets.entity.Film;
import com.wqy.cinematickets.entity.Pagination;
import com.wqy.cinematickets.entity.ProjectionHall;
import com.wqy.cinematickets.entity.User;

import java.util.List;

public interface ManagerDao {
    //根据用户名和密码查询用户是否存在
    int isUser(User u);
    //根据用户名和密码查询用户信息
   User getUserByNameAndPassword(User u);
    //插入影片
   int addMovie(Film film);
   //查询所有影片
    List<Film> getAllMovie();
    //分页查询影片库
    List<Film> getMoviePagination(Pagination pagination);
    //查询影片库数量
    int getAllMovieCount();
    //修改影片库的影片信息
    int updateMovieById(Film film);
    //根据影片id删除影片库的影片
    int delMovieByid(int id);
    //根据电影名字影片库模糊查询
    List<Film> getMovieByName(Pagination pagination);
    //根据电影名字影片库模糊查询的数据个数
    int getMovieByNameCount(String name);


    //添加近期影片
    int addRecentFilms(int mid);
    //根据近期影片id删除近期影片
    int delRecentFilmsById(int rid);
    //获取近期影片
    List<Film> getAllRecentFilms();
    //添加放映厅
    int addProjectionHall(ProjectionHall projectionHall);
    //修改放映厅
    int updateProjectionHallById(ProjectionHall projectionHall);
    //获取所有放映厅
    List<ProjectionHall> getAllProjectionHall();
}
