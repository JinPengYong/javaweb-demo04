package com.cheer.web.servlet;

import com.cheer.model.Admin;
import com.cheer.service.AdminService;
import com.cheer.service.impl.AdminServiceImpl;
import com.cheer.util.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", urlPatterns = "/servlet/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(ExcelReader.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            AdminService adminService=new AdminServiceImpl();
            Admin admin = adminService.find(username);
            if (admin != null) {
                if (username.equals(admin.getUsername())&&password.equals(admin.getPassword())) {
                    response.sendRedirect("../page_admin_index.html");
                }
                else{
                    response.sendRedirect("../admin_login.html");
                }
            }else{
                response.sendRedirect("../admin_login.html");
            }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
