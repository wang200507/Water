package com.water.Api.service;


public interface YzmService<T> {
 public T YzmLogin(T t);

 public T YzmGetMobilenum(T t);

 public T YzmGetVcodeAndReleaseMobile(T t);

 public T YzmGetVcodeAndHoldMobilenum(T t);

 public T YzmAddIgnoreList(T t);

 public T YzmGetUserInfos(T t);

 public T YzmGetRecvingInfo(T t);
}
