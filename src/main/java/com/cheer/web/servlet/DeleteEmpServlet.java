package com.cheer.web.servlet;

import com.cheer.service.EmpService;
import com.cheer.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmpServlet", urlPatterns = "/servlet/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String empNo = request.getParameter("empNo");
        if (null == empNo || "".equals(empNo)) {
            throw new ServletException("empNo为空，删除失败！");
        }

        EmpService empService = new EmpServiceImpl();
        try {
            empService.delete(Integer.valueOf(empNo));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
        response.sendRedirect("../empList.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
