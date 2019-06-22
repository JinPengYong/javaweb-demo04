package com.cheer.dao;

import com.cheer.model.Question;

import java.util.List;

public interface QuestionMapper {
    List<Question> getList();


   int insert(Question question);

   List<String> getResult();
}
