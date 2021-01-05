package com.kemyond.virus.common;



public enum CodeMessage {
    SUCCESS(1,"操作成功"),
    FAILURE(0,"操作失败"),
    NETWORKERROR(500,"后台代码错误"),
    NOFILE(404,"资源没找到");
    private  int  code;
    private  String msg;
    private CodeMessage(int  code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
