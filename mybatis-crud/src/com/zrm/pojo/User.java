package com.zrm.pojo;

public class User {
 
	private  Integer id = null;
	private  String name = null;
	private  String  pwd = null;
	
	
	public  Integer getId() {
		return id;
	}


	public  void setId(Integer id) {
		this.id = id;
	}


	public  String getName() {
		return name;
	}


	public  void setName(String name) {
		this.name = name;
	}


	public  String getPwd() {
		return pwd;
	}


	public  void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public String toString() {
		return "User [id ="+getId()+"   name = "+getName()+"   password = "+getPwd()+"]";
	}
	
	
	
	
}
