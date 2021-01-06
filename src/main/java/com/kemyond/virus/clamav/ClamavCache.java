package com.kemyond.virus.clamav;

import java.util.LinkedList;

/**
 * 病毒检测队列
 * @Author zdl
 * @Date 2021/1/5 15:51
 * @Version 1.0
 */
public class ClamavCache {
    private static final LinkedList<String> filePaths=new LinkedList<>();

    /**
     * 从缓存队列中获取一个文件路径
     * @return
     */
    public static synchronized String pop(){
       return filePaths.pop();
    }

    /**
     * 将一个需要病毒检测的文件路径放入队列中
     * @param filePath
     */
    public static synchronized void push(String filePath){
        filePaths.push(filePath);
    }

    /**
     * 获取缓存队列的大小
     * @return
     */
    public static int size(){
        return  filePaths.size();
    }

    /**
     * 清理缓存数据
     */
    public static void  clear(){
        filePaths.clear();
    }
}
