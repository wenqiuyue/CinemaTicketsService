package com.wqy.cinematickets.service.receptionservice.impl;

import com.wqy.cinematickets.dao.receptiondao.ReceptionDao;
import com.wqy.cinematickets.entity.ExclusivePiece;
import com.wqy.cinematickets.entity.Film;
import com.wqy.cinematickets.service.receptionservice.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReceptionServiceImpl implements ReceptionService {
    @Autowired
     private ReceptionDao receptionDao;

    @Override
    //获取近期热门影片
    public List<Film> GetAllPopularRecentFilmsService(){
        return receptionDao.getAllPopularRecentFilms();
    }

    @Override
    //根据电影id查询电影信息
    public Film GetFilmByIdService(int mid){
        return receptionDao.getFilmById(mid);
    }

    @Override
    //根据电影id查询电影排片
    public List<ExclusivePiece> GetExclusivePieceByIdService(int mid){
        return receptionDao.getExclusivePieceById(mid);
    }
}
