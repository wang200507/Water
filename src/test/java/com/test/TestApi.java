package com.test;

import java.io.IOException;

import org.apache.http.ParseException;
import org.junit.Test;

import com.water.Api.entity.ApiBean;
import com.water.Api.entity.YzmBean;
import com.water.Api.plugin.VerificationCodeApiPlugin;
import com.water.Api.service.YzmService;
import com.water.Api.service.Impl.DzapiYzmServiceImpl;

public class TestApi {
 @Test
 public void Api() throws ParseException, IOException {

  YzmService<YzmBean> service = new DzapiYzmServiceImpl();
  YzmBean t = new YzmBean();
  t.setUid("qq13125198122");
  t.setPwd("qq123456");
  t.setPid(7371);
  t.setNext_pid("7371");
  service.YzmLogin(t);
  service.YzmGetMobilenum(t);
  VerificationCodeApiPlugin codeApiPlugin = new VerificationCodeApiPlugin();
  codeApiPlugin.requestByGetMethod(
   new ApiBean("http://mp.soqi.cn/login/saveRegister.xhtml?mobile=" + t.getMobiles()[0] + "&&recId=BA38717EF51C84317CB0BCD31B48A3E7",
    "58.219.161.8", "8888", false, true));
  while (t.getCode().equals("")) {
   service.YzmGetVcodeAndHoldMobilenum(t);
   if (!t.getCode().equals("")) {
    System.out.println(t.getCode());
    break;
   }
  }
 }
}

