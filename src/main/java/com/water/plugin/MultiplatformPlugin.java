package com.water.plugin;

import org.apache.log4j.Logger;

import com.jfinal.plugin.IPlugin;

/**
 * 多线程开启代理 排除 80端口及8080 端口
 * 
 * @author Administrator
 *
 */
public class MultiplatformPlugin implements IPlugin {

 private static Logger log = Logger.getLogger(MultiplatformPlugin.class);

 private String proxyHost;// 代理ip
 private String proxyPort;// 代理端口

 public String getProxyHost() {
  return proxyHost;
 }

 public void setProxyHost(String proxyHost) {
  this.proxyHost = proxyHost;
 }

 public String getProxyPort() {
  return proxyPort;
 }

 public void setProxyPort(String proxyPort) {
  this.proxyPort = proxyPort;
 }

 public MultiplatformPlugin(String proxyHost, String proxyPort) {
  this.proxyHost = proxyHost;
  this.proxyPort = proxyPort;
 }

 public MultiplatformPlugin() {
 }
 /**
  * 数据批处理大小，每批次处理一万行
  */
 protected static final int splitDataSize = 10000;
 @Override
 public boolean start() {
  // TODO Auto-generated method stub
  log.info("MultiplatformPlugin.start...请求发出中,您的代理ip:" + proxyHost);
  System.setProperty("http.proxyHost", proxyHost); // 设置代理ip
  System.setProperty("http.proxyPort", proxyPort); // 设置代理ip端口
  return true;
 }

 @Override
 public boolean stop() {
  // TODO Auto-generated method stub
  return false;
 }
}
