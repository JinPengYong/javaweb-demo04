package com.cheer.service;

import com.cheer.model.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getList();

    void delete(Integer empNo) throws Exception;

    int insert(Emp emp);

    int update(Emp emp);

    Emp getEmp(Integer empNo);
}
