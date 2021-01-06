package com.kemyond.virus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kemyond.virus.common.CodeMessage;
import com.kemyond.virus.common.Record;
import com.kemyond.virus.dao.HisVirusMapper;
import com.kemyond.virus.domain.HisVirus;
import com.kemyond.virus.domain.HisVirusExample;
import com.kemyond.virus.service.VirusService;
import com.kemyond.virus.util.ClamavUtil;
import com.kemyond.virus.vo.qo.BaseQo;
import com.kemyond.virus.vo.qo.HisVirusQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zdl
 * @Date 2021/1/5 10:54
 * @Version 1.0
 */
@Service
public class VirusServiceImpl implements VirusService {
    @Autowired
    HisVirusMapper hisVirusMapper;
    @Override
    public Record getList(HisVirusQo qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        List<HisVirus> hisViri = hisVirusMapper.selecltByCondition(qo);
        return new Record(new PageInfo(hisViri));
    }

    @Override
    public Record startTask(String fileName) {
        return null;
    }

    @Override
    public Record getVersion() throws Exception {
        Map<String,Object> map=new HashMap<>();
        String result = ClamavUtil.getVersion();
        String[] arr = result.split("\\s+");
        String month=ClamavUtil.getMonthNum(arr[2]);
        String[] versions = arr[1].split("/");
        StringBuffer buffer=new StringBuffer();
        buffer.append(arr[5].trim()).append("-").append(month).append("-").append(arr[3]).append(" ").append(arr[4]);
        map.put("sysVersion",versions[0]);
        map.put("dbVersion",versions[1]);
        map.put("status",1);
        map.put("dbVersionDate",buffer.toString());
        return new Record(map);
    }

    @Override
    public Record getScanStatus(String fileMark) throws Exception {
        Record result=null;
        Byte scanStatus=3;
        String detail ="";
        try {
            HisVirusExample example=new HisVirusExample();
            example.createCriteria().andFileMarkEqualTo(fileMark);
            List<HisVirus> hisViri = hisVirusMapper.selectByExample(example);
            if(hisViri!=null&&hisViri.size()>0){
                scanStatus = hisViri.get(0).getScanStatus();
                detail=hisViri.get(0).getDetail();
            }
            Map map=new HashMap();
            map.put("scanStatus",scanStatus);
            map.put("scanDetail", detail);
            result=new Record(map);
        }catch (Exception e){
            result=new Record(Record.FAILURE,"操作失败",e);
        }
        return result;
    }
}
