package com.cheer.web.servlet;

import com.cheer.model.Emp;
import com.cheer.service.EmpService;
import com.cheer.service.impl.EmpServiceImpl;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdateServlet2", urlPatterns = "/servlet/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(InsertServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        String empNo = request.getParameter("empNo");
        EmpService empService=new EmpServiceImpl();
        Emp emp = empService.getEmp(Integer.valueOf(empNo));
        List<Emp> list=new ArrayList<Emp>();
        list.add(emp);
        Gson gson=new Gson();

        String  s= gson.toJson(list);
        writer.println(s);
        writer.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
