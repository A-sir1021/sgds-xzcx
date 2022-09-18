package com.example.test.dao;

import com.example.test.pojo.ViewSpace;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ViewSpaceMapper {
    int deleteByPrimaryKey(Integer space_id);

    int insert(int record);

    ViewSpace selectByPrimaryKey(Integer space_id);

    List<ViewSpace> selectAll();

    int updateByPrimaryKey(int record);
}