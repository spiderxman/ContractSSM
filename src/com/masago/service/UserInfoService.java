package com.masago.service;

import java.util.List;

import com.masago.bean.UserInfoBean;

public interface UserInfoService {

    List<UserInfoBean> getUserInfo(String userId, String userName, String userRoot, String delFlag);
    
    void setUserInfo(UserInfoBean userInfo);

}