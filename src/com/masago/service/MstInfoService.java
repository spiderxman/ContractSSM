package com.masago.service;

import java.util.List;

import com.masago.bean.MstAuthorityBean;

public interface MstInfoService {

    List<MstAuthorityBean> getMstAuthorityInfo(String authorityCd);

}