package com.wqy.cinematickets.service.managerservice;

import com.wqy.cinematickets.entity.Film;
import com.wqy.cinematickets.entity.Pagination;
import com.wqy.cinematickets.entity.User;

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
}
