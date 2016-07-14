package com.water.Api.plugin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.water.Api.entity.ApiBean;

public class VerificationCodeApiPlugin {

 private static Logger log = Logger.getLogger(VerificationCodeApiPlugin.class);
 private HttpEntity entity;
 /**
  * 通过GET方式发起http请求
  */
 @Test
 public HttpEntity requestByGetMethod(ApiBean apiBean) {
  // 创建默认的httpClient实例
  CloseableHttpClient httpClient = new MultiplatformPlugin()
   .start();
  try {
   // 用get方法发送http请求
   HttpGet get = new HttpGet(apiBean.getGetUrl());
   if (apiBean.getProxyBoolen()) {
    log.info(("设置代理成功:" + apiBean.getRequestConfig().getLocalAddress() + ":" + apiBean.getRequestConfig().getProxy()));
    get.setConfig(apiBean.getRequestConfig());
   }
   log.info("执行get请求:...." + get.getURI());
   CloseableHttpResponse httpResponse = null;
   // 发送get请求
   httpResponse = httpClient.execute(get);
   try {
    // response实体
    entity = httpResponse.getEntity();
    if (null != entity) {
     log.info(("响应状态码:" + httpResponse.getStatusLine()));
     log.info("-------------------------------------------------");
     log.info("响应内容:" + EntityUtils.toString(entity));
     log.info("-------------------------------------------------");
    }
   } finally {
    httpResponse.close();
   }
  } catch (Exception e) {
   e.printStackTrace();
  } finally {
   try {
    closeHttpClient(httpClient);
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
  return entity;
 }

 /**
  * POST方式发起http请求
  */
 @Test
 public HttpEntity requestByPostMethod(ApiBean apiBean) {
  CloseableHttpClient httpClient = new MultiplatformPlugin().start();
  try {
   HttpPost post = new HttpPost(apiBean.getGetUrl()); // 这里用上本机的某个工程做测试
   if (apiBean.getProxyBoolen()) {
    post.setConfig(apiBean.getRequestConfig());
   }
   // 创建参数列表
   List<NameValuePair> list = apiBean.getParameter();
   // url格式编码
   UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list, "UTF-8");
   post.setEntity(uefEntity);
   System.out.println("POST 请求...." + post.getURI());
   // 执行请求
   CloseableHttpResponse httpResponse = httpClient.execute(post);
   try {
    entity = httpResponse.getEntity();
    if (null != entity) {
     log.info("-------------------------------------------------------");
     log.info(EntityUtils.toString(uefEntity));
     log.info("-------------------------------------------------------");
    }
   } finally {
    httpResponse.close();
   }

  } catch (UnsupportedEncodingException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   try {
    closeHttpClient(httpClient);
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
  return entity;
 }


 private void closeHttpClient(CloseableHttpClient client) throws IOException {
  if (client != null) {
   client.close();
  }
 }
} 
