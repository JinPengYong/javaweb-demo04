package com.cheer.web.servlet;

import com.cheer.model.Emp;
import com.cheer.service.EmpService;
import com.cheer.service.impl.EmpServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "InsertServlet", urlPatterns = "/servlet/InsertServlet")
public class InsertServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(InsertServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Emp emp=new Emp();
        /*String[] emps = request.getParameterValues("emp");
        emp.setEmpNo(Integer.valueOf(emps[0]));
        emp.seteName((emps[1]));
        emp.setJob((emps[2]));
        emp.setMgr(Integer.valueOf(emps[3]));
        emp.setHireDate((emps[4]));
        emp.setSal(Double.valueOf(emps[5]));
        emp.setCom(Double.valueOf(emps[6]));
        emp.setDeptNo(Integer.valueOf(emps[7]));*/

       Map<String, String[]> map = request.getParameterMap();

       //要导入beanutils jar包
        try {
            BeanUtils.populate(emp,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        LOGGER.debug(emp);

        EmpService empService=new EmpServiceImpl();
        int i = empService.insert(emp);
        response.sendRedirect("../empList.html");


        System.out.println(i);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
