package com.cheer.service.impl;

import com.cheer.dao.QuestionMapper;
import com.cheer.model.Question;
import com.cheer.service.QuestionService;
import com.cheer.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    @Override
    public List<Question> getList() {
        SqlSession session = MybatisUtils.getSqlSession();
        QuestionMapper mapper = session.getMapper(QuestionMapper.class);
        List<Question> QuestionList = mapper.getList();

        MybatisUtils.closeSession(session);
        return QuestionList;
    }

    @Override
    public int insert(Question question) {
        SqlSession session = MybatisUtils.getSqlSession();
        QuestionMapper mapper = session.getMapper(QuestionMapper.class);
        int result = mapper.insert(question);
        MybatisUtils.closeSession(session);
        return result;
    }

    @Override
    public List<String> getResultList() {
        SqlSession session = MybatisUtils.getSqlSession();
        QuestionMapper mapper = session.getMapper(QuestionMapper.class);
        List<String> resultList = mapper.getResult();
        MybatisUtils.closeSession(session);
        return resultList;
    }
}
