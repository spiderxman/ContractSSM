package com.masago.controllor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.masago.bean.UserInfoBean;
import com.masago.service.GetUserInfoService;

@Controller
public class LoginController {    //用户控制器

    @Autowired
    @Qualifier("GetUserInfoService")
    private GetUserInfoService getUserInfoService; //注意业务层

    @RequestMapping("/Login")  //初期表示
    public ModelAndView Init(HttpSession session){

    	ModelAndView mv = new ModelAndView();
        mv.setViewName("Login"); //重新设置view视图页面
        return mv; //返回视图
    }
    
    @RequestMapping("/Login1")  //处理login请求
    public ModelAndView login(String userId, String password, ModelAndView mv, HttpSession session){

        UserInfoBean userInfoBean = getUserInfoService.login(userId); //调用业务层方法返回一个实例对象

        if (userInfoBean!=null) {  //判断查到的数据是否为空
            //如果用户不为空，设在Session域中
            //session.setAttribute("user", userInfoBean);
        	
        	if(password.equals(userInfoBean.getPassword())){
				//パスワード一致
        		session.setAttribute("userInfo", userInfoBean);
        		//重定向到main页面中
//                mv.setView(new RedirectView("MainMenu"));
                mv.setViewName("MainMenu");
			}else{
				//パスワードの不一致
				mv.addObject("message","密码错误");
	            mv.setViewName("Login"); //重新设置view视图页面
			}
        }else {
            mv.addObject("message","用户不存在");
            mv.setViewName("Login"); //重新设置view视图页面
        }
        return mv; //返回视图
    }

}