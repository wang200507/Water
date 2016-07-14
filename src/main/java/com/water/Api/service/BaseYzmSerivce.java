package com.water.Api.service;

import com.dz.API;
import com.dz.LogonResp;
import com.water.Api.entity.ApiBean;
import com.water.Api.plugin.VerificationCodeApiPlugin;

public class BaseYzmSerivce {

 VerificationCodeApiPlugin codeApiPlugin = new VerificationCodeApiPlugin();

 public LogonResp YzmLogin(ApiBean apiBean) {

  return API.getInstance().loginIn("", "");
 }

 public String YzmGetMobilenum(ApiBean apiBean) {
  // TODO Auto-generated method stub
  return null;
 }

 public String YzmGetVcodeAndReleaseMobile(ApiBean apiBean) {
  // TODO Auto-generated method stub
  return null;
 }

 public String YzmGetVcodeAndHoldMobilenum(ApiBean apiBean) {
  // TODO Auto-generated method stub
  return null;
 }

 public String YzmAddIgnoreList(ApiBean apiBean) {
  // TODO Auto-generated method stub
  return null;
 }

 public String YzmGetUserInfos(ApiBean apiBean) {
  // TODO Auto-generated method stub
  return null;
 }

 public String YzmGetRecvingInfo(ApiBean apiBean) {
  // TODO Auto-generated method stub
  return null;
 }
}
