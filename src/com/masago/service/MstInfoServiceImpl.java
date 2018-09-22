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

import com.masago.bean.MstAuthorityBean;
import com.masago.mapper.MstInfoMapper;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("MstInfoService")
public class MstInfoServiceImpl implements MstInfoService{    //表示service层

    @Autowired
    private MstInfoMapper mstInfoMapper;
    /**
     * 
     */
    @Transactional(readOnly=true)
    public List<MstAuthorityBean> getMstAuthorityInfo(String authorityCd) {
        return mstInfoMapper.selectMstAuthorityInfo(authorityCd);//调用DB层方法
    }

}