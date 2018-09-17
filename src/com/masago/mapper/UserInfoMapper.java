/**
 *
 */
/**
 * @author user
 *
 */
package com.masago.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.masago.bean.UserInfoBean;

public interface UserInfoMapper {
	List<UserInfoBean> selectUserInfo(@Param("userId") String userId,@Param("userName") String userName,@Param("userRoot") String userRoot,@Param("delFlag") String delFlag);//@param表示上面sql中的参数
}