package com.cheer.web.servlet;

import com.cheer.model.Emp;
import com.cheer.service.EmpService;
import com.cheer.service.impl.EmpServiceImpl;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdateServlet1", urlPatterns = "/servlet/UpdateServlet1")
public class UpdateServlet1 extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(InsertServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Emp emp=new Emp();
        try {
            BeanUtils.populate(emp,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        LOGGER.debug(emp);

        EmpService empService=new EmpServiceImpl();
        int i = empService.update(emp);
        response.sendRedirect("../empList1.html");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
