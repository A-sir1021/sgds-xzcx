package com.example.test.dao;

import com.example.test.pojo.ViewPoint;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ViewPointMapper {
    int deleteByPrimaryKey(Integer point_id);

    int insert(ViewPoint record);

    ViewPoint selectByPrimaryKey(Integer point_id);

    List<ViewPoint> selectAll();

    int updateByPrimaryKey(ViewPoint record);
}