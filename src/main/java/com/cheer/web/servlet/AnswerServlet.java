package com.cheer.web.servlet;

import com.cheer.model.Examinee;
import com.cheer.service.ExamineeService;
import com.cheer.service.QuestionService;
import com.cheer.service.impl.ExamineeServiceImpl;
import com.cheer.service.impl.QuestionServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AnswerServlet", urlPatterns = "/servlet/AnswerServlet")
public class AnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        QuestionService questionService = new QuestionServiceImpl();
        List<String> resultList = questionService.getResultList();
        String[] arrs = request.getParameterValues("answer");
        int x=0;
        int y=0;
        for (int i = 0; i <arrs.length; i++) {
            String s = resultList.get(i);

            if(s.split("：")[1].equals(arrs[i])){
                x++;
            }else{
                y++;
            }
        }
        System.out.println(x);
        HttpSession session = request.getSession();
        session.setAttribute("yes",x);
        Object num = session.getAttribute("num");
        PrintWriter writer = response.getWriter();
        int score=x*20;
        String result=null;
        if(score>=100){
            result="合格";
        }else{
            result="不合格";
        }
        Examinee examinee=new Examinee(String.valueOf(num),x,y,score,result);
        session.setAttribute("examinee",examinee);
        ExamineeService examineeService=new ExamineeServiceImpl();
        int update = examineeService.update(examinee);
        System.out.println(arrs.length-(x+y));
        writer.println(update);
        writer.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
