package com.huangpeng.cloud.mapper;

import com.huangpeng.cloud.model.HaPersonAudioRecordEntity;

public interface HaPersonAudioRecordEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(HaPersonAudioRecordEntity record);

    int insertSelective(HaPersonAudioRecordEntity record);

    HaPersonAudioRecordEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HaPersonAudioRecordEntity record);

    int updateByPrimaryKey(HaPersonAudioRecordEntity record);
}