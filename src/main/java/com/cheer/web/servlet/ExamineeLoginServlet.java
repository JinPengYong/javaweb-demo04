package com.cheer.web.servlet;


import com.cheer.model.Examinee;
import com.cheer.service.ExamineeService;

import com.cheer.service.impl.ExamineeServiceImpl;
import com.cheer.util.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ExamineeLoginServlet", urlPatterns = "/servlet/ExamineeLoginServlet")
public class ExamineeLoginServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(ExcelReader.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        String password = request.getParameter("password");
        ExamineeService examineeService=new ExamineeServiceImpl();
        Examinee examinee = examineeService.find(num);
        if (examinee != null&&num !=null&&password.equals(examinee.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("num",num);
            response.sendRedirect("../page_examinee_index.html");
        }
        else{
            response.sendRedirect("../examinee_login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
