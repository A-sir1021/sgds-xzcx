package com.example.test.dao;

import com.example.test.pojo.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SalaryMapper {

//    int insert(@Param("id")Integer id, @Param("name")String name,@Param("pid")Integer pid,@Param("zindex")Integer zindex,@Param("istype")Integer istype,@Param("descpt")String descpt,@Param("code")String code,@Param("icon")String icon,@Param("page")String page,@Param("insert_time")Timestamp insert_time,@Param("update_time")Timestamp update_time);

  int insertSalary(Salary salary);

  int updateSalary(Salary salary);

  Salary querySalary(String salaId);

}
