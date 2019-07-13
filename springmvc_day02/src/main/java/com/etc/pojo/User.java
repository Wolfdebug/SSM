package com.etc.pojo;

public class User {
    private String uname;
    private String upwd;

    public String getUname() {
        return uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
