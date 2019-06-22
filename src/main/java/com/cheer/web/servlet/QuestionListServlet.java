package com.cheer.web.servlet;


import com.cheer.model.Question;

import com.cheer.service.QuestionService;

import com.cheer.service.impl.QuestionServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QuestionListServlet", urlPatterns = "/servlet/QuestionListServlet")
public class QuestionListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        QuestionService questionService = new QuestionServiceImpl();
        List<Question> questionList = questionService.getList();


        Gson gson=new Gson();
        String s = gson.toJson(questionList);
        PrintWriter writer = response.getWriter();
        writer.write(s);
        writer.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
