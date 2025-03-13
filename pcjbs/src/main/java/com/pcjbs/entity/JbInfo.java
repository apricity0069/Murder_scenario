package com.pcjbs.entity;

public class JbInfo {
    private String jb_id;
    private String jb_name;
    private String jb_tag;
    private int jb_num;
    private String jb_jj;
    private int jb_price;
    private int jb_status;
    private String jb_nd;
    private String jb_wz;
    private int yy_num;
    private int jb_yy_id;

    public String getJb_id() {
        return jb_id;
    }

    public void setJb_id(String jb_id) {
        this.jb_id = jb_id;
    }

    public int getJb_yy_id() {
        return jb_yy_id;
    }

    public void setJb_yy_id(int jb_yy_id) {
        this.jb_yy_id = jb_yy_id;
    }

    public int getYy_num() {
        return yy_num;
    }

    public void setYy_num(int yy_num) {
        this.yy_num = yy_num;
    }

    public String getJb_wz() {
        return jb_wz;
    }

    public void setJb_wz(String jb_wz) {
        this.jb_wz = jb_wz;
    }

    public String getJb_nd() {
        return jb_nd;
    }

    public void setJb_nd(String jb_nd) {
        this.jb_nd = jb_nd;
    }

    public String getJb_name() {
        return jb_name;
    }

    public void setJb_name(String jb_name) {
        this.jb_name = jb_name;
    }

    public String getJb_tag() {
        return jb_tag;
    }

    public void setJb_tag(String jb_tag) {
        this.jb_tag = jb_tag;
    }

    public int getJb_num() {
        return jb_num;
    }

    public void setJb_num(int jb_num) {
        this.jb_num = jb_num;
    }

    public String getJb_jj() {
        return jb_jj;
    }

    public void setJb_jj(String jb_jj) {
        this.jb_jj = jb_jj;
    }

    public int getJb_price() {
        return jb_price;
    }

    public void setJb_price(int jb_price) {
        this.jb_price = jb_price;
    }

    public int getJb_status() {
        return jb_status;
    }

    public void setJb_status(int jb_status) {
        this.jb_status = jb_status;
    }

    @Override
    public String toString() {
        return "JbInfo{" +
                "jb_id=" + jb_id +
                ", jb_name='" + jb_name + '\'' +
                ", jb_tag='" + jb_tag + '\'' +
                ", jb_num=" + jb_num +
                ", jb_jj='" + jb_jj + '\'' +
                ", jb_price=" + jb_price +
                ", jb_status=" + jb_status +
                ", jb_nd='" + jb_nd + '\'' +
                ", jb_wz='" + jb_wz + '\'' +
                ", yy_num=" + yy_num +
                ", jb_yy_id=" + jb_yy_id +
                '}';
    }
}

