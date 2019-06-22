package com.cheer.service;

import com.cheer.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getList();

    int insert(Question question);

    List<String> getResultList();
}
