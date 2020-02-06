package com.wqy.cinematickets.dao.receptiondao;

import com.wqy.cinematickets.entity.*;

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
    //获取所有影片分数
    List<FilmReview> getFilmScore();
    //改变影片分数
    int updateFilmScore(Film film);
    //根据影片id获取该影片所有评价
    List<FilmReview> getFilmReviewInfoById(int mid);
    //添加想看的影片
    int addWantSeeFilm(WantFilm wantFilm);
    //查询添加想看的影片是否已添加
    int isAddWantSeeFilm(WantFilm wantFilm);
    //根据排片id多表获取排片信息
    ExclusivePiece getExclusivepieceInfoByEid(int eid);
    //插入订单
    int addOrder(Order order);
    //插入订单座位
    int addSeatselection(SeatSelection seatSelection);
    //获取某场次已被选的座位
    List<SeatSelection> getSeatselectionByEid(int eid);
    //根据订单编号获取订单信息
    Order getOrderInfo(String oid);
    //根据订单编号查询座位
    List<SeatSelection> getSeatselectionByOid(String oid);
    //根据用户id查询用户姓名和头像
    User getNameAndPicById(int id);
    //修改用户头像和用户名
    int updatePicAndName(User user);
    //查询想看的电影
    List<Film> getMyLikeFilm(int uid);
    //修改密码
    int updatePassword(User user);
    //根据用户id获取订单列表
    List<Order> getUserOrderList(int uid);
}
