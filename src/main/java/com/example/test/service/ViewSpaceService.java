package com.example.test.service;

import com.example.test.pojo.ViewSpace;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

public interface ViewSpaceService {
    int deleteByPrimaryKey(Integer space_id);

    int insert(int record);

    ViewSpace selectByPrimaryKey(Integer space_id);

    List<ViewSpace> selectAll();

    int updateByPrimaryKey(int record);
}