package com.wqy.cinematickets.service.managerservice.impl;

import com.wqy.cinematickets.dao.managerdao.ManagerDao;
import com.wqy.cinematickets.entity.*;
import com.wqy.cinematickets.service.managerservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    //插入影片
    public Boolean addMovie(Film film){
        int i=managerDao.addMovie(film);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //查询所有影片
    public List<Film> getAllMovie(){
        return managerDao.getAllMovie();
    }

    @Override
    //分页查询影片库
    public List<Film> getMoviePagination(Pagination pagination){
        return managerDao.getMoviePagination(pagination);
    }

    @Override
    //查询影片库数量
    public int getAllMovieCount(){
        return managerDao.getAllMovieCount();
    }

    @Override
    //修改影片库的影片信息
    public Boolean updateMovieById(Film film){
        int i=managerDao.updateMovieById(film);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //根据影片id删除影片库的影片
    public Boolean delMovieByid(int id){
        int i=managerDao.delMovieByid(id);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //根据电影名字影片库模糊查询
    public List<Film> getMovieByName(Pagination pagination){
        return managerDao.getMovieByName(pagination);
    }

    @Override
    //根据电影名字影片库模糊查询的数据个数
    public int getMovieByNameCount(String name){
        return managerDao.getMovieByNameCount(name);
    }

    @Override
    //添加近期影片
    public Boolean addRecentFilms(int mid){
        int i=managerDao.addRecentFilms(mid);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //根据影片id删除近期影片
    public Boolean delRecentFilmsById(int mid){
        int i=managerDao.delRecentFilmsById(mid);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //获取近期影片
    public List<Film> getAllRecentFilms(){
        return managerDao.getAllRecentFilms();
    }
    @Override
    //近期影片票房
    public int getFilmNum(int eid){
        return managerDao.getFilmNum(eid);
    }
    @Override
    //添加放映厅
    public Boolean addProjectionHall(ProjectionHall projectionHall){
        int i=managerDao.addProjectionHall(projectionHall);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //修改放映厅
    public Boolean updateProjectionHallById(ProjectionHall projectionHall){
        int i=managerDao.updateProjectionHallById(projectionHall);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //获取所有放映厅
    public List<ProjectionHall> getAllProjectionHall(){
        return managerDao.getAllProjectionHall();
    }

    @Override
    //删除放映厅
    public Boolean delProjectionHallById(int pid){
        int i=managerDao.delProjectionHallById(pid);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //添加场次安排
    public Boolean addExclusivePiece(ExclusivePiece exclusivePiece){
        int i=managerDao.addExclusivePiece(exclusivePiece);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //单表查询场次
    public List<ExclusivePiece> getExclusivepiece(){
        return managerDao.getExclusivepiece();
    }

    @Override
    //多表获取排片信息
    public List<ExclusivePiece> getExclusivepieceInfo(Pagination pagination){
        return managerDao.getExclusivepieceInfo(pagination);
    }

    @Override
    //获取场次数量
    public int getExclusivepieceCount(){
        return managerDao.getExclusivepieceCount();
    }

    @Override
    //根据电影名字对场次安排模糊查询
    public List<ExclusivePiece> gettExclusivepieceByName(Pagination pagination){
        return managerDao.gettExclusivepieceByName((pagination));
    }

    @Override
    //获取电影名模糊查询场次的数量
    public int getExclusivepieceByNameCount(String name){
        return managerDao.getExclusivepieceByNameCount(name);
    }

    @Override
    //删除场次
    public Boolean delExclusivepieceById(int eid){
        int i=managerDao.delExclusivepieceById(eid);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //编辑场次
    public Boolean UpdateExclusivepieceByIdService(ExclusivePiece exclusivePiece){
        int i = managerDao.updateExclusivepieceById(exclusivePiece);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    //删除不是当日的排片数据
    public int DelExclusivepieceNotTodyService(){
        return managerDao.delExclusivepieceNotTody();
    }
}
