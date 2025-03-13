package com.pcjbs.entity;

public class Admin {
   private String admin_id;
   private String admin_zh;
   private String admin_pwd;

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id='" + admin_id + '\'' +
                ", admin_zh='" + admin_zh + '\'' +
                ", admin_pwd='" + admin_pwd + '\'' +
                '}';
    }

    public String getAdmin_id() {return admin_id;}
    public void setAdmin_id(String admin_id) {this.admin_id = admin_id;}
    public String getAdmin_zh() {return  admin_zh;}
    public void  setAdmin_zh(String admin_zh) {this.admin_zh = admin_zh;}
    public String getAdmin_pwd() {return admin_pwd;}
    public void setAdmin_pwd(String admin_pwd){this.admin_pwd=admin_pwd;}
}
