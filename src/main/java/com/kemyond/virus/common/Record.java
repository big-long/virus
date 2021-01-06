package com.kemyond.virus.common;

import lombok.Data;

/**
 * @Author zdl
 * @Date 2021/1/4 15:51
 * @Version 1.0
 */
@Data
public class Record<T> {
    public  static final int SUCCESS=1;
    public static final int FAILURE=0;
    private int code;
    private  String msg;
    private T data;

    public Record(){
        this.code=SUCCESS;
        this.msg="操作成功";
    }
    public Record(int code,String msg){
       this.msg=msg;
       this.code=code;
    }
    public Record(int code,String msg,T data){
        this(code,msg);
        this.data=data;
    }
    public Record(T data){
        this.data=data;
       this.code=SUCCESS;
       this.msg="操作成功";
    }
//    private Record(String msg,T data){
//        this.msg=msg;
//        this.data=data;
//        this.code=FAILURE;
//    }
}
