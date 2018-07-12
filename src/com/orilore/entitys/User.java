package com.orilore.entitys;
public class User{
	private Integer uid;
	public void setUid(Integer uid){
		this.uid=uid;
	}
	public Integer getUid(){
		return this.uid;
	}
	private String uname;
	public void setUname(String uname){
		this.uname=uname;
	}
	public String getUname(){
		return this.uname;
	}
	private String password;
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}
}