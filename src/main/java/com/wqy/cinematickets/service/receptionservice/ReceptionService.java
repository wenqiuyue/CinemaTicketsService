package com.wqy.cinematickets.service.receptionservice;

import com.wqy.cinematickets.entity.ExclusivePiece;
import com.wqy.cinematickets.entity.Film;
import com.wqy.cinematickets.entity.FilmReview;

import java.util.List;

public interface ReceptionService {
    //获取近期热门影片
    List<Film> GetAllPopularRecentFilmsService();
    //根据电影id查询电影信息
    Film GetFilmByIdService(int mid);
    //根据电影id查询电影排片
    List<ExclusivePiece> GetExclusivePieceByIdService(int mid);
    //添加影评
    Boolean AddFilmReviewService(FilmReview filmReview);
    //根据影片id获取该影片影评
    List<Integer> GetFilmReviewByMidService(int mid);
}
