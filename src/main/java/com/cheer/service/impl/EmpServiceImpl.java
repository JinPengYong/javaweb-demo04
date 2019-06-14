package com.cheer.service.impl;

import com.cheer.dao.EmpMapper;
import com.cheer.model.Emp;
import com.cheer.service.EmpService;
import com.cheer.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpServiceImpl implements EmpService {
   public static void main(String[] args) {
        //System.out.println(new EmpServiceImpl().getList());
    }
    @Override
    public List<Emp> getList() {
        SqlSession session = MybatisUtils.getSqlSession();
        //List<Emp> empList = session.getMapper(EmpMapper.class).getList();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
       List<Emp> empList = mapper.getList();

        MybatisUtils.closeSession(session);
        return empList;
    }

    @Override
    public void delete(Integer empNo) throws Exception {
        SqlSession session = MybatisUtils.getSqlSession();
        int result = session.getMapper(EmpMapper.class).delete(empNo);
        MybatisUtils.closeSession(session);
        if (result != 1) {
            throw new Exception("删除失败！");
        }
    }

    @Override
    public int insert(Emp emp) {
       SqlSession session=MybatisUtils.getSqlSession();
       int result=session.getMapper(EmpMapper.class).insert(emp);
        MybatisUtils.closeSession(session);
        return result;
    }

    @Override
    public int update(Emp emp) {
       SqlSession session=MybatisUtils.getSqlSession();
       int result=session.getMapper(EmpMapper.class).update(emp);
       MybatisUtils.closeSession(session);
        return result;
    }

    @Override
    public Emp getEmp(Integer empNo) {
        SqlSession session = MybatisUtils.getSqlSession();
        Emp emp = session.getMapper(EmpMapper.class).getEmp(empNo);
        return emp;
    }
}
