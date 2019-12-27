package com.wqy.cinematickets.service.receptionservice;

import com.wqy.cinematickets.entity.ExclusivePiece;
import com.wqy.cinematickets.entity.Film;

import java.util.List;

public interface ReceptionService {
    //获取近期热门影片
    List<Film> GetAllPopularRecentFilmsService();
    //根据电影id查询电影信息
    Film GetFilmByIdService(int mid);
    //根据电影id查询电影排片
    List<ExclusivePiece> GetExclusivePieceByIdService(int mid);
}
