package com.cheer.web.servlet;

import com.cheer.model.Emp;
import com.cheer.service.EmpService;
import com.cheer.service.impl.EmpServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "UpdateServlet", urlPatterns = "/servlet/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String empNo = request.getParameter("empNo");

        EmpService empService=new EmpServiceImpl();
        empService.update(Integer.valueOf(empNo));
        response.sendRedirect("../empList.html");

*/

        Emp emp=new Emp();




        Map<String, String[]> map = request.getParameterMap();


        try {
            BeanUtils.populate(emp,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        EmpService empService=new EmpServiceImpl();
        empService.update(emp);
        response.sendRedirect("../empList.html");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
