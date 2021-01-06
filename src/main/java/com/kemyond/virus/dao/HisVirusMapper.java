package com.kemyond.virus.dao;

import com.kemyond.virus.domain.HisVirus;
import com.kemyond.virus.domain.HisVirusExample;
import java.util.List;

import com.kemyond.virus.vo.qo.HisVirusQo;
import org.apache.ibatis.annotations.Param;

public interface HisVirusMapper {
    long countByExample(HisVirusExample example);

    int deleteByExample(HisVirusExample example);

    int insert(HisVirus record);

    int insertSelective(HisVirus record);

    List<HisVirus> selectByExample(HisVirusExample example);

    int updateByExampleSelective(@Param("record") HisVirus record, @Param("example") HisVirusExample example);

    int updateByExample(@Param("record") HisVirus record, @Param("example") HisVirusExample example);

    List<HisVirus> selecltByCondition(@Param("qo")HisVirusQo qo);
}