package com.kemyond.virus.util;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zdl
 * @Date 2021/1/5 11:33
 * @Version 1.0
 */
public class ClamavUtil {
    private static final Logger LOG= LoggerFactory.getLogger(ClamavUtil.class);
    private final static Runtime runtime =Runtime.getRuntime();

    /**
     * 获取病毒的版本信息
     * @return
     */
    public static String getVersion(){
        Map<String,Object> map=new HashMap<>();
        StringBuilder cmd=new StringBuilder();
        cmd.append("clamdscan -version");
        return exec(cmd.toString());
    }

    /**
     * 执行shell命令并将结果以字符串形式返回
     * @param cmd shell命令
     * @return
     */
    public static String exec(String cmd){
        StringBuffer out =new StringBuffer();
        try {
            Process exec = runtime.exec(cmd);
            InputStream in = exec.getInputStream();
            BufferedReader bs = new BufferedReader(new InputStreamReader(in));
            // System.out.println("[check] now size \n"+bs.readLine());
            byte[] b = new byte[1024];
            for (int n; (n = in.read(b)) != -1;) {
                  out.append(new String(b, 0, n));
            }
        }catch (IOException e){
            LOG.error("执行shell命令失败",e);
        }
        return  out.toString();
    }

    public static Map<String, Object> scanFile(String fileName){
        Map<String,Object> map=new HashMap<>();
        StringBuilder cmd=new StringBuilder();
        cmd.append("clamdscan ").append(fileName);
        String exec = exec(cmd.toString());
        LOG.info(fileName+":"+exec);
        if(!StringUtils.isEmpty(exec)){
            String[] arr = exec.split("\n");
            for (String str:arr) {
                String[] arr3 = str.split(": ");
                if(arr3.length==2){
                    map.put(arr3[0].trim(),arr3[1].trim());
//                    LOG.info(arr3[0]+":"+arr3[1]);
                }
//                LOG.info(arr3[0]);
            }
        }
        return map;
    }

    /**
     * 文件的完整路径
     * @param fileName
     * @return 返回文件的sha256值
     */
    public static String getSha256(String fileName){
        StringBuilder cmd=new StringBuilder();
        cmd.append("sha256sum ").append(fileName);
        return exec(cmd.toString()).split("\\s+")[0];
    }

    /**
     * 将指定文件移动到指定的目录里面
     * @param fileName
     * @param forder
     * @return
     */
    public static boolean moveTo(String fileName ,String forder){
        StringBuilder cmd=new StringBuilder();
        cmd.append("mv ").append(fileName).append(" ").append(forder);
        String exec = exec(cmd.toString());
        return StringUtils.isEmpty(exec);
    }
    /**
     *  根据月份的英文缩写返回对应的月份阿拉伯数字
     * @param s
     * @return
     */
    public static String getMonthNum(String s) {
        String month="";
        switch (s){
            case "Jan":
                month="01";
                break;
            case "Feb":
                month="02";
                break;
            case "Mar":
                month="03";
                break;
            case "Apr":
                month="04";
                break;
            case "May":
                month="05";
                break;
            case "Jun":
                month="06";
                break;
            case "Jul":
                month="07";
                break;
            case "Aug":
                month="08";
                break;
            case "Sep":
                month="09";
                break;
            case "Oct":
                month="10";
                break;
            case "Nov":
                month="11";
                break;
            case "Dec":
                month="12";
                break;

        }
        return month;
    }
}
