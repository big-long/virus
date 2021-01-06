package com.kemyond.virus.service;

import com.kemyond.virus.common.Record;
import com.kemyond.virus.vo.qo.BaseQo;
import com.kemyond.virus.vo.qo.HisVirusQo;

/**
 * @User zdl
 * @Date 2021/1/5 10:51
 * @Version 1.0
 */
public interface VirusService {
    /**
     * 获取病毒检测历史记录
     * @return
     * @throws Exception
     */
    Record getList(HisVirusQo qo) throws Exception;

    /**
     * 根据文件名称开始执行一个任务
     * @param fileName 文件名称
     * @return
     * @throws  Exception
     */
    Record startTask(String fileName) throws Exception;

    /**
     * 获取版本信息
     * @return
     * @throws Exception
     */
    Record getVersion() throws Exception;

    /**
     * 根据文件的标识查找该文件的病毒检测结果
     * @param fileMark 文件标识
     * @return
     * @throws Exception
     */
    Record getScanStatus(String fileMark) throws Exception;
}
