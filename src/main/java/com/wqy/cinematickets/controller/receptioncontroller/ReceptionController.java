package com.wqy.cinematickets.controller.receptioncontroller;

import com.wqy.cinematickets.entity.Film;
import com.wqy.cinematickets.entity.Result;
import com.wqy.cinematickets.service.receptionservice.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
