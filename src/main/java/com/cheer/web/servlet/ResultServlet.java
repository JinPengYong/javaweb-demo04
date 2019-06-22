package com.cheer.web.servlet;

import com.cheer.model.Examinee;
import com.cheer.service.ExamineeService;
import com.cheer.service.impl.ExamineeServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ResultServlet", urlPatterns = "/servlet/ResultServlet")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Object examinee = session.getAttribute("examinee");
        List<Examinee> examineeList=new ArrayList<Examinee>();
        examineeList.add((Examinee)examinee);
        Gson gson=new Gson();
        PrintWriter writer = response.getWriter();
        String s = gson.toJson(examineeList);
        writer.write(s);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
