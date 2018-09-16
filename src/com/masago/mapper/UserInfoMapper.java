/**
 *
 */
/**
 * @author user
 *
 */
package com.masago.mapper;

import org.apache.ibatis.annotations.Param;

import com.masago.bean.UserInfoBean;

public interface UserInfoMapper {
    UserInfoBean selectUserInfo(@Param("userId") String userId);//@param表示上面sql中的参数
}