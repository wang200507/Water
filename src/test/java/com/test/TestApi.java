package com.test;

import org.junit.Test;

import com.water.Api.entity.ApiBean;
import com.water.Api.plugin.VerificationCodeApiPlugin;

public class TestApi {
 @Test
 public void Api() {
  VerificationCodeApiPlugin codeApiPlugin = new VerificationCodeApiPlugin();
  codeApiPlugin.requestByGetMethod(
   new ApiBean("http://api.jmyzm.com/http.do?action=loginIn&uid=qq1106264855&pwd=qq123456", "58.219.161.8", "8888", false));
 }
}
