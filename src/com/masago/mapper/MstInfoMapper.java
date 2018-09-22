/**
 * @author user
 *
 */
package com.masago.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.masago.bean.MstAuthorityBean;

public interface MstInfoMapper {
	List<MstAuthorityBean> selectMstAuthorityInfo(@Param("authorityCd") String authorityCd);//@param表示参数
}