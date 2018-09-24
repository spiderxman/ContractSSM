package com.masago.controllor;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.masago.bean.UserInfoBean;
import com.masago.common.PropertyUtil;
import com.masago.service.UserInfoService;

@Controller
public class LoginController {    //用户控制器

	//共通クラス
	PropertyUtil util = null;
	
    @Autowired
    @Qualifier("UserInfoService")
    private UserInfoService userInfoService; //注意业务层

    @RequestMapping("/Login")  //处理login请求
    public ModelAndView login(String userId, String password, String req_gid, ModelAndView mv, HttpSession session){
    	if(StringUtils.isEmpty(req_gid)) {
    		session.removeAttribute("userInfo");
    		mv.setViewName("Login"); //重新设置view视图页面
    		return mv; //返回视图
    	}
    	List<UserInfoBean> userInfoList = userInfoService.getUserInfo(userId,null,null,null); //调用业务层方法返回一个实例对象

        if (userInfoList!=null&&userInfoList.size()>0) {  //判断查到的数据是否为空
            //如果用户不为空，设在Session域中
            //session.setAttribute("user", userInfoBean);
        	UserInfoBean userInfoBean = userInfoList.get(0);
        	if(password.equals(userInfoBean.getPassword())){
				//パスワード一致
        		session.setAttribute("userInfo", userInfoBean);
        		//重定向到main页面中
                mv.setView(new RedirectView("MainMenu"));
//                mv.setViewName("MainMenu");
			}else{
				//パスワードの不一致
				mv.addObject("message",util.getProperty("MSG_E001"));
	            mv.setViewName("Login"); //重新设置view视图页面
			}
        }else {
            mv.addObject("message","用户不存在");
            mv.setViewName("Login"); //重新设置view视图页面
        }
        return mv; //返回视图
    }

}