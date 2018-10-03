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
import com.masago.common.PropertiesFileLoader;
import com.masago.service.MstInfoService;
import com.masago.service.UserInfoService;

import net.sf.json.JSONArray;

@Controller
public class UserAddController {

    @Autowired
    @Qualifier("UserInfoService")
    private UserInfoService userInfoService;
    
    @Autowired
    private MstInfoService mstInfoService; //権限取得

    /**
     * 初期表示
     * @param mv
     * @param msg
     * @return
     */
    @RequestMapping("/UserAddInit")
    public ModelAndView userAddInit(ModelAndView mv, @ModelAttribute("errorMessage") String msg){
    	UserInfoBean userInfo = new UserInfoBean();
    	//権限取得
    	List<MstAuthorityBean> mstAuthorityList = mstInfoService.getMstAuthorityInfo(null);
    	mv.addObject("userInfo", userInfo);
    	mv.addObject("mstAuthorityList", mstAuthorityList);
        mv.setViewName("User/UserAdd"); //重新设置view视图页面
        mv.addObject("errorMessage", msg);
        return mv;
    }
    /**
     * ユーザ登録
     * @param userInfo
     * @param mv
     * @return
     */
    @RequestMapping("/UserAdd")
    public String userAdd(UserInfoBean userInfo, Model mv){
    	userInfoService.setUserInfo(userInfo);
    	mv.addAttribute("errorMessage", PropertiesFileLoader.getProperty("MSG_E003"));
        return "redirect:/UserAddInit";
    }
    
    /**
     * ユーザ存在チェック
     * @param userId
     * @return
     */
    @RequestMapping(value ="/CheckUserIdExists", method = RequestMethod.POST)
    @ResponseBody
    public JSONArray checkUserIdExists(String userId){
    	List<UserInfoBean> userInfoList = userInfoService.getUserInfo(userId, "", "", "");
    	JSONArray jsonArray = JSONArray.fromObject(userInfoList);
        return jsonArray; //返回视图
    }


}