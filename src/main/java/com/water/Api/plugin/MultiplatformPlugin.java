package com.water.Api.plugin;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

/**
 * 开启代理 排除 80端口及8080 端口
 * 
 * @author Administrator
 *
 */
public class MultiplatformPlugin {

 private static Logger log = Logger.getLogger(MultiplatformPlugin.class);

 private static final CloseableHttpClient httpClient = HttpClients.createDefault();

 public MultiplatformPlugin() {
 }

 public CloseableHttpClient start() {
  return httpClient;
 }
}
