package com.water.Api.entity;

/**
 * 
 * @author Administrator
 *
 */
public class YzmBean {

 private String uid; // 用户名
 private String pwd; // 密码
 private String Token; // 唯一标识
 private String mobile; // 指定号码获取 //加黑时多个 按,分割
 private Integer size; // 获取号码数
 private String operator;// 运营商
 private String province; // 指定地区获取号码
 private String notProvince; // 排除指定地区号码
 private String next_pid; // 下个要接收的项目ID
 private String author_uid; // 软件开发者用户名

 public String getUid() {
  return uid;
 }

 public void setUid(String uid) {
  this.uid = uid;
 }

 public String getPwd() {
  return pwd;
 }

 public void setPwd(String pwd) {
  this.pwd = pwd;
 }

 public String getToken() {
  return Token;
 }

 public void setToken(String token) {
  Token = token;
 }

 public String getMobile() {
  return mobile;
 }

 public void setMobile(String mobile) {
  this.mobile = mobile;
 }

 public Integer getSize() {
  return size;
 }

 public void setSize(Integer size) {
  this.size = size;
 }

 public String getOperator() {
  return operator;
 }

 public void setOperator(String operator) {
  this.operator = operator;
 }

 public String getProvince() {
  return province;
 }

 public void setProvince(String province) {
  this.province = province;
 }

 public String getNotProvince() {
  return notProvince;
 }

 public void setNotProvince(String notProvince) {
  this.notProvince = notProvince;
 }

 public String getNext_pid() {
  return next_pid;
 }

 public void setNext_pid(String next_pid) {
  this.next_pid = next_pid;
 }

 public String getAuthor_uid() {
  return author_uid;
 }

 public void setAuthor_uid(String author_uid) {
  this.author_uid = author_uid;
 }

}
