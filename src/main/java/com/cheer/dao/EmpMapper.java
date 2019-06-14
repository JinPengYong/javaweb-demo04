package com.cheer.dao;

import com.cheer.model.Emp;
import com.cheer.model.QueryVo;

import java.util.List;
import java.util.Map;

public interface EmpMapper {

    Emp getEmp(Integer empNo);

    List<Emp> getM(String eName);

    List<Emp> getList();
    //void int 都可以
    int insert(Emp emp);

    int update(Emp emp);

    //int delete(Emp emp);


    List<Emp> getPageList();

    //根据queryOv中的条件查询用户
    List<Emp> findEmpByVo(QueryVo vo);

    Emp getEmpResultMap(Integer empNo);

    Map<String, Object> getEmpMap(Integer empNo);

    List<Emp> getList2(Emp emp);

    List<Map<String,Object>> getEmpMap1(Emp emp);

    int  delete(Integer empNo);





}
