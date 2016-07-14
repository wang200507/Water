package com.water.Api.Tools;

import java.util.Map;

import com.water.Api.constant.Constants;

public class Tools {
 public static String ReturnMessage(String message) {
  LoadPopertiesFile.loadSqlFile("message.properties");
  for (Map.Entry<String, String> messages : Constants.loadSqlMap.entrySet()) {
   if (message.toUpperCase().equals(messages.getKey().toUpperCase().toString())) {
    return messages.getValue().toString();
   }
  }
  return message;
 }

 public static String GetUrl(String url) {
  return "";
 }
}
