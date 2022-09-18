package com.example.test.service;

import com.example.test.pojo.Role;
import java.util.List;

public interface RoleService {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    Role selectByPrimaryKey(String rolePhone);

    Role selectByPhone(String rolePhone);
    /*List<Role> selectAll();*/

    /*int updateByPrimaryKey(String record);*/


}