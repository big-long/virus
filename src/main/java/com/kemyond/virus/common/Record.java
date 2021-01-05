package com.kemyond.virus.common;

import lombok.Data;

/**
 * @Author zdl
 * @Date 2021/1/4 15:51
 * @Version 1.0
 */
@Data
public class Record<T> {
    private CodeMessage codeMessage;
    private T data;

    public Record(){
        this.codeMessage=CodeMessage.SUCCESS;
    }
    public Record(CodeMessage codeMessage){
       this.codeMessage=codeMessage;
    }
    public Record(CodeMessage codeMessage,T data){
        this(codeMessage);
        this.data=data;
    }
    public Record(T data){
        this.data=data;
        this.codeMessage=CodeMessage.SUCCESS;
    }
}
