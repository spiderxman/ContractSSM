package com.masago.controllor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.masago.bean.UserInfoBean;
import com.masago.service.GetUserInfoService;

@Controller
public class MainMenuController {    //用户控制器

//    @Autowired
//    @Qualifier("GetUserInfoService")
//    private GetUserInfoService getUserInfoService; //注意业务层

    @RequestMapping("/MainMenu")  //初期表示
    public ModelAndView Init(HttpSession session){

    	ModelAndView mv = new ModelAndView();
        mv.setViewName("MainMenu"); //重新设置view视图页面
        return mv; //返回视图
    }


}