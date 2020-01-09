package com.wqy.cinematickets.controller.receptioncontroller;

import com.wqy.cinematickets.entity.ExclusivePiece;
import com.wqy.cinematickets.entity.Film;
import com.wqy.cinematickets.entity.FilmReview;
import com.wqy.cinematickets.entity.Result;
import com.wqy.cinematickets.service.receptionservice.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ReceptionController {
    @Autowired
    private ReceptionService receptionService;

    //获取近期热门影片
    @RequestMapping(value = "/GetAllPopularRecentFilms",method = RequestMethod.GET)
    public Result<List<Film>> GetAllPopularRecentFilms(){
        List<Film> filmList = receptionService.GetAllPopularRecentFilmsService();
        Result<List<Film>> listResult = new Result<List<Film>>();
        if(filmList != null){
            listResult.setCode(0);
            listResult.setBody(filmList);
        }else {
            listResult.setCode(100);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //根据电影id查询电影信息
    @RequestMapping(value = "/GetFilmById",method = RequestMethod.GET)
    public Result<Film> GetFilmById(int mid){
        Film film = receptionService.GetFilmByIdService(mid);
        Result<Film> filmResult = new Result<Film>();
        if(film != null){
            filmResult.setCode(0);
            filmResult.setBody(film);
        }else {
            filmResult.setCode(1000);
            filmResult.setMessage("没有查询到数据");
        }
        return filmResult;
    }

    //根据电影id查询电影排片
    @RequestMapping(value = "/GetExclusivePieceById",method = RequestMethod.GET)
    public Result<List<ExclusivePiece>> GetExclusivePieceById(int mid){
        List<ExclusivePiece> exclusivePieceList = receptionService.GetExclusivePieceByIdService(mid);
        Result<List<ExclusivePiece>> listResult = new Result<List<ExclusivePiece>>();
        if(exclusivePieceList != null){
            listResult.setCode(0);
            listResult.setBody(exclusivePieceList);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }

    //添加影评
    @RequestMapping(value = "/AddFilmReview",method = RequestMethod.POST)
    public Boolean AddFilmReview(@RequestBody FilmReview filmReview){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        filmReview.setEvaluatetime(str);
        return receptionService.AddFilmReviewService(filmReview);
    }

    //根据影片id获取该影片影评
    @RequestMapping(value = "/GetFilmReviewByMid",method = RequestMethod.GET)
    public Result<List<Integer>> GetFilmReviewByMid(int mid){
        List<Integer> list = receptionService.GetFilmReviewByMidService(mid);
        Result<List<Integer>> listResult = new Result<List<Integer>>();
        if(list != null){
            listResult.setCode(0);
            listResult.setBody(list);
        }else {
            listResult.setCode(1000);
            listResult.setMessage("没有查询到数据");
        }
        return listResult;
    }
}
