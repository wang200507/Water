package com.water.Api.service;

import com.water.Api.entity.ApiBean;

public interface YzmService {
 public <T> T YzmLogin(ApiBean apiBean);

 public <T> T YzmGetMobilenum(ApiBean apiBean);

 public <T> T YzmGetVcodeAndReleaseMobile(ApiBean apiBean);

 public <T> T YzmGetVcodeAndHoldMobilenum(ApiBean apiBean);

 public <T> T YzmAddIgnoreList(ApiBean apiBean);

 public <T> T YzmGetUserInfos(ApiBean apiBean);

 public <T> T YzmGetRecvingInfo(ApiBean apiBean);
}
