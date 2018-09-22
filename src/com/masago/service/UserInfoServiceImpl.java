/**
 *
 */
/**
 * @author user
 *
 */
package com.masago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.masago.bean.UserInfoBean;
import com.masago.mapper.UserInfoMapper;
import com.masago.service.UserInfoService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService{    //表示service层

    @Autowired
    private UserInfoMapper usermapper;
    /**
     * 
     */
    @Transactional(readOnly=true)
    public List<UserInfoBean> getUserInfo(String userId, String userName, String userRoot, String delFlag) {
        return usermapper.selectUserInfo(userId, userName, userRoot, delFlag);//调用DB层方法
    }
    /**
     * 
     */
    @Transactional
    public void setUserInfo(UserInfoBean userInfo) {
        usermapper.insertUserInfo(userInfo);//调用DB层方法
    }

}