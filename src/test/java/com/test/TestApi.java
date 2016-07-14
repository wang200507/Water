package com.test;

import java.io.IOException;

import org.apache.http.ParseException;
import org.junit.Test;

import com.water.Api.entity.ApiBean;
import com.water.Api.plugin.VerificationCodeApiPlugin;

public class TestApi {
 @Test
 public void Api() throws ParseException, IOException {
  VerificationCodeApiPlugin codeApiPlugin = new VerificationCodeApiPlugin();
  codeApiPlugin.requestByGetMethod(
   new ApiBean("http://mp.soqi.cn/login/jxcrctc.xhtml?mobile=15594825110&&recId=BA38717EF51C84317CB0BCD31B48A3E7&&checkCode=3116",
    "58.219.161.8",
    "8888", false, true));
 }
}

