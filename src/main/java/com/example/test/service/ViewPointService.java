package com.example.test.service;

import com.example.test.pojo.ViewPoint;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

public interface ViewPointService {
    int deleteByPrimaryKey(Integer point_id);

    int insert(ViewPoint record);

    ViewPoint selectByPrimaryKey(Integer point_id);

    List<ViewPoint> selectAll();

    int updateByPrimaryKey(ViewPoint record);
}