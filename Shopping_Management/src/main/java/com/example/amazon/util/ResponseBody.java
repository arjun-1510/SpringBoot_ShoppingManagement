package com.example.amazon.util;

import org.springframework.http.HttpStatus;

public class ResponseBody<T>  {
	
	
	
private int  status;
private String msg;
private T data ;
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}






}