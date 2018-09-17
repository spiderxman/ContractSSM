package com.masago.controllor;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.masago.bean.UserInfoBean;
import com.masago.service.GetUserInfoService;

@Controller
public class UserSearchController {    //用户控制器

    @Autowired
    @Qualifier("GetUserInfoService")
    private GetUserInfoService getUserInfoService; //注意业务层

    @RequestMapping("/UserSearchInit")  //初期表示
    public ModelAndView init(HttpSession session){
    	ModelAndView mv = new ModelAndView();
//    	UserInfoBean userInfoBean = (UserInfoBean)session.getAttribute("userInfo");
//    	mv.addObject("userName", userInfoBean.getUserName());
        mv.setViewName("UserSearch"); //重新设置view视图页面
        return mv; //返回视图
    }
    
    @RequestMapping("/UserSearch")  //初期表示
    public ModelAndView userSearch(String userId, String userName, String userRoot, String delFlag, HttpSession session){
    	ModelAndView mv = new ModelAndView();
    	List<UserInfoBean> userInfoList = getUserInfoService.getUserInfo(userId, userName, userRoot, delFlag);
    	mv.addObject("userInfoList", userInfoList);
        mv.setViewName("UserSearch"); //重新设置view视图页面
        return mv; //返回视图
    }


}