package com.masago.controllor;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.masago.bean.UserInfoBean;

@Controller
public class MainMenuController {    //用户控制器

	@RequestMapping("/MainMenu")  //初期表示
    public ModelAndView Init(HttpSession session){
    	ModelAndView mv = new ModelAndView();
    	UserInfoBean userInfoBean = (UserInfoBean)session.getAttribute("userInfo");
    	mv.addObject("userName", userInfoBean.getUserName());
        mv.setViewName("MainMenu"); //重新设置view视图页面
        return mv; //返回视图
    }


}