/**
 *
 */
/**
 * @author user
 *
 */
package com.masago.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.masago.bean.UserInfoBean;
import com.masago.mapper.UserInfoMapper;
import com.masago.service.GetUserInfoService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("GetUserInfoService")
public class GetUserInfoServiceImpl implements GetUserInfoService{    //表示service层

    @Autowired
    private UserInfoMapper usermapper;

    @Transactional(readOnly=true)
    public UserInfoBean login(String userId) {

        return usermapper.selectUserInfo(userId);//调用DB层方法

    }

}