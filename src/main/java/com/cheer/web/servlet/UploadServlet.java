package com.cheer.web.servlet;

import com.cheer.model.Admin;


import com.cheer.model.Question;
import com.cheer.service.QuestionService;
import com.cheer.service.impl.QuestionServiceImpl;
import com.cheer.util.ExcelReader;
import com.cheer.util.IOUtils;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = "/servlet/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(UploadServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        File repository = (File) request.getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        Admin admin = new Admin();

        String path=null;
        for (FileItem item : items) {

                String name = item.getName();
                String tmpDir = System.getProperty("user.home");
                LOGGER.debug("tmpDir={}", tmpDir);
                File avatarDir = new File(tmpDir + "/avatar");
                if (!avatarDir.exists()) {
                    // 创建路径
                    if(!avatarDir.mkdirs()) {
                        LOGGER.error("创建路径失败！");
                        throw new ServletException("注册失败");
                    }
                }
                String fileName = admin.getUsername() + "-" + name;
                IOUtils.writeToFile(item.getInputStream(), avatarDir + "/" + fileName);
                path=avatarDir + "/" + fileName;

        }
        //  path:c:/Users/Administrator\avatar/null-questions.xlsx
        List<Question> questionList = ExcelReader.readExcel(path);
        QuestionService questionService=new QuestionServiceImpl();
        for (Question question : questionList) {
            questionService.insert(question);
            System.out.println(question);

        }
        //response.sendRedirect();
        LOGGER.error(path);

}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doPost(request, response);
    }
}
