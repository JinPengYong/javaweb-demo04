package com.cheer.web.servlet;

import com.cheer.model.Emp;
import com.cheer.service.EmpService;
import com.cheer.service.impl.EmpServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpListServlet", urlPatterns = "/servlet/EmpListServlet")
public class EmpListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        EmpService empService = new EmpServiceImpl();
        List<Emp> empList = empService.getList();
        Gson gson = new Gson();
        String  s= gson.toJson(empList);

        writer.println(s);

        writer.close();
        //System.out.println(s);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
