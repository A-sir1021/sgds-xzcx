package com.example.test.service.impl;

import com.example.test.dao.SalaryMapper;
import com.example.test.pojo.Salary;
import com.example.test.service.SalaryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class SalaryServiceimpl implements SalaryService {

    @Resource
    SalaryMapper salaryMapper;

    @Resource
    Salary salary;
    @Override
    public int insertSalary(Salary salary) {
        int insert = salaryMapper.insertSalary(salary);
        return insert;
    }

    @Override
    public Salary querySalary(String salaryId) {
        salary = null;
        if (StringUtils.isEmpty(salaryId)){
            return null;
        } else {
            salary = salaryMapper.querySalary(salaryId);
        }
        return salary;
    }

    @Override
    public int updateSalary(Salary salary) {

        return salaryMapper.updateSalary(salary);
    }
}
