package com.masago.controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.masago.bean.MstAuthorityBean;
import com.masago.bean.UserInfoBean;
import com.masago.service.MstInfoService;
import com.masago.service.UserInfoService;

import net.sf.json.JSONArray;

@Controller
public class UserAddController {

    @Autowired
    @Qualifier("UserInfoService")
    private UserInfoService userInfoService;
    
    @Autowired
    private MstInfoService mstInfoService; //权限表数据取得

    @RequestMapping("/UserAddInit")  //初期表示
    public ModelAndView userAddInit(ModelAndView mv, @ModelAttribute("errorMessage") String msg){
//    	ModelAndView mv = new ModelAndView();
    	UserInfoBean userInfo = new UserInfoBean();
    	
    	List<MstAuthorityBean> mstAuthorityList = mstInfoService.getMstAuthorityInfo(null);

    	mv.addObject("userInfo", userInfo);
    	mv.addObject("mstAuthorityList", mstAuthorityList);
        mv.setViewName("User/UserAdd"); //重新设置view视图页面
        
        mv.addObject("errorMessage", msg);
        return mv; //返回视图
    }
    
    @RequestMapping("/UserAdd")  //初期表示
    public String userAdd(UserInfoBean userInfo, Model mv){
//    	ModelAndView mv = new ModelAndView();
    	userInfoService.setUserInfo(userInfo);
//    	mv.addObject("errorMessage", "ユーザ1件登録しました。");
    	mv.addAttribute("errorMessage", "ユーザ1件登録しました。");
//        mv.setViewName("UserAddInit"); //重新设置view视图页面
        return "redirect:/UserAddInit"; //返回视图
    }
    
    @RequestMapping(value ="/CheckUserIdExists", method = RequestMethod.POST)
    @ResponseBody
    public JSONArray checkUserIdExists(String userId){
    	List<UserInfoBean> userInfoList = userInfoService.getUserInfo(userId, "", "", "");
    	JSONArray jsonArray = JSONArray.fromObject(userInfoList);
        return jsonArray; //返回视图
    }


}