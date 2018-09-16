package com.masago.service;

import com.masago.bean.UserInfoBean;

public interface GetUserInfoService {

    UserInfoBean login(String userId);

}