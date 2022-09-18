package com.example.test.service;


import com.example.test.pojo.Salary;
import org.apache.ibatis.annotations.Param;

public interface SalaryService {

    int insertSalary(@Param("salary") Salary salary );

    Salary querySalary(@Param("salaryId") String salaryId);

    int updateSalary(@Param("salary") Salary salary );

}
