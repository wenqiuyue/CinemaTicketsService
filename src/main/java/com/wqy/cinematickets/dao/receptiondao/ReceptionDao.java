package com.wqy.cinematickets.dao.receptiondao;

import com.wqy.cinematickets.entity.ExclusivePiece;
import com.wqy.cinematickets.entity.Film;
import com.wqy.cinematickets.entity.FilmReview;

import java.util.List;

public interface ReceptionDao {
    //获取近期热门影片
    List<Film> getAllPopularRecentFilms();
    //根据电影id查询电影信息
    Film getFilmById(int mid);
    //根据电影id查询电影排片
    List<ExclusivePiece> getExclusivePieceById(int mid);
    //添加影评
    int addFilmReview(FilmReview filmReview);
    //根据影片id获取该影片影评
    List<Integer> getFilmReviewByMid(int mid);
}
