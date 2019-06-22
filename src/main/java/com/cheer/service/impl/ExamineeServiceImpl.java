package com.cheer.service.impl;

import com.cheer.dao.ExamineeMapper;



import com.cheer.model.Examinee;
import com.cheer.service.ExamineeService;
import com.cheer.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class ExamineeServiceImpl implements ExamineeService {
    @Override
    public Examinee find(String num) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Examinee examinee = sqlSession.getMapper(ExamineeMapper.class).find(num);
        MybatisUtils.closeSession(sqlSession);
        return examinee;

    }

    @Override
    public int update(Examinee examinee) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int update = sqlSession.getMapper(ExamineeMapper.class).update(examinee);
        MybatisUtils.closeSession(sqlSession);
        return update;
    }
}
