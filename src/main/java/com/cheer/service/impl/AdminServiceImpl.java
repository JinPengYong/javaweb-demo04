package com.cheer.service.impl;

import com.cheer.dao.AdminMapper;
import com.cheer.model.Admin;
import com.cheer.service.AdminService;
import com.cheer.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class AdminServiceImpl implements AdminService {
    @Override
    public Admin find(String username) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Admin admin = sqlSession.getMapper(AdminMapper.class).find(username);
        MybatisUtils.closeSession(sqlSession);
        return admin;
    }
}
