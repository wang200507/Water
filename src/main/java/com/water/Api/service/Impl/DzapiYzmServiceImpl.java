package com.water.Api.service.Impl;

import org.apache.log4j.Logger;
import org.codehaus.plexus.util.StringUtils;

import com.dz.API;
import com.water.Api.entity.YzmBean;
import com.water.Api.service.YzmService;

/**
 * 
 * @author gaoj
 * @author 实现验证码接码平台1
 *
 */
public class DzapiYzmServiceImpl implements YzmService<YzmBean> {

 private static Logger log = Logger.getLogger(DzapiYzmServiceImpl.class);

 @Override
 public YzmBean YzmLogin(YzmBean t) {
  // TODO Auto-generated method stub
  t.setToken(API.getInstance().loginIn(t.getUid(), t.getPwd()).getToken());
  return t;
 }

 @Override
 public YzmBean YzmGetMobilenum(YzmBean t) {
  // TODO Auto-generated method stub
  t.setMobiles(
   API.getInstance().getMobilenum(t.getPid(), t.getUid(), t.getToken(), t.getSize(), t.getProvince(), t.getOperator(), t.getNotProvince())
    .getMobile());
  return t;
 }

 @Override
 public YzmBean YzmGetVcodeAndReleaseMobile(YzmBean t) {
  // TODO Auto-generated method stub
  String[] mobiles = new String[t.getMobiles().length];
  String[] Codes = new String[t.getMobiles().length];
  if (t.getMobiles().length > 1) {
   for (int i = 0; i < t.getMobiles().length; i++) {
    mobiles[i] = API.getInstance().getVcodeAndReleaseMobile(t.getMobiles()[i], t.getUid(), t.getToken(), t.getAuthor_uid()).getMobile();
    Codes[i] = API.getInstance().getVcodeAndReleaseMobile(t.getMobiles()[i], t.getUid(), t.getToken(), t.getAuthor_uid()).getVerifyCode();
   }
  } else {
   t.setMobile(API.getInstance().getVcodeAndReleaseMobile(t.getMobiles()[0], t.getUid(), t.getToken(), t.getAuthor_uid()).getMobile());
   t.setCode(API.getInstance().getVcodeAndReleaseMobile(t.getMobiles()[0], t.getUid(), t.getToken(), t.getAuthor_uid()).getVerifyCode());
  }
  t.setMobiles(mobiles);
  t.setCodes(Codes);
  return t;
 }

 @Override
 public YzmBean YzmGetVcodeAndHoldMobilenum(YzmBean t) {
  String[] mobiles = new String[t.getMobiles().length];
  String[] Codes = new String[t.getMobiles().length];
  if (t.getMobiles().length > 1) {
   for (int i = 0; i < t.getMobiles().length; i++) {
    mobiles[i] = API.getInstance().getVcodeAndHoldMobilenum(t.getMobiles()[i], t.getUid(), t.getToken(), t.getNext_pid(), t.getAuthor_uid())
     .getMobile();
    Codes[i] = API.getInstance().getVcodeAndHoldMobilenum(t.getMobiles()[i], t.getUid(), t.getToken(), t.getNext_pid(), t.getAuthor_uid())
     .getVerifyCode();
   }
  } else {
   t.setMobile(API.getInstance().getVcodeAndHoldMobilenum(t.getMobiles()[0], t.getUid(), t.getToken(), t.getNext_pid(), t.getAuthor_uid())
    .getMobile());
   t.setCode(API.getInstance().getVcodeAndHoldMobilenum(t.getMobiles()[0], t.getUid(), t.getToken(), t.getNext_pid(), t.getAuthor_uid())
    .getVerifyCode());
  }
  t.setMobiles(mobiles);
  t.setCodes(Codes);
  return t;
 }

 @Override
 public YzmBean YzmAddIgnoreList(YzmBean t) {
  // TODO Auto-generated method stub
  t.setSize(API.getInstance().addIgnoreList(t.getPid(), StringUtils.join(t.getMobiles(), ","), t.getUid(), t.getToken()).getRow());
  return t;
 }

 @Override
 public YzmBean YzmGetUserInfos(YzmBean t) {
  // TODO Auto-generated method stub
  t.setMessge(API.getInstance().getUserInfos(t.getUid(), t.getToken()).getResult());
  return t;
 }

 @Override
 public YzmBean YzmGetRecvingInfo(YzmBean t) {

  return t;
 }

}
