package com.kemyond.virus.rest;

import com.kemyond.virus.common.CodeMessage;
import com.kemyond.virus.common.Record;
import com.kemyond.virus.service.VirusService;
import com.kemyond.virus.vo.qo.HisVirusQo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

/**
 * @Author zdl
 * @Date 2021/1/5 10:49
 * @Version 1.0
 */
@Api("病毒检测")
@CrossOrigin
@RestController("/virus")
public class VirusController {
    private static final Logger LOG= LoggerFactory.getLogger(VirusController.class);
    @Autowired
    VirusService virusService;

    @ApiOperation("获取病毒检测系统版本信息")
    @GetMapping("/getVersion")
    public Record getVersion(){
        try {
           return virusService.getVersion();
        }catch (Exception e){
            LOG.error("获取版本信息失败",e);
            return new Record(Record.FAILURE,"操作失败",e);
        }
    }
    @ApiOperation("查询病毒检测历史记录")
    @GetMapping("/list")
    public Record getList(HisVirusQo qo){
        try {
            return virusService.getList(qo);
        }catch (Exception e){
            LOG.error("查询病毒检测历史记录失败：",e);
            return new Record(Record.FAILURE,"操作失败",e);
        }
    }
    @ApiOperation("获取某条记录的检测结果")
    @GetMapping("/getStatus")
    public Record getStatus(String fileMark){
        try {
            return virusService.getScanStatus(fileMark);
        } catch (Exception e) {
           LOG.error("获取记录的检测结果失败：",e);
            return new Record(Record.FAILURE,"操作失败",e);
        }
    }
}
