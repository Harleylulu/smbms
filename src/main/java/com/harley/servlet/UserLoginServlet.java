package com.harley.servlet;

import com.harley.pojo.User;
import com.harley.service.UserService;
import com.harley.service.UserServiceImpl;
import com.harley.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode = req.getParameter("userCode");
        String password = req.getParameter("userPassword");
        User user = userService.login(userCode,password);
        if(user != null){
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            resp.sendRedirect("/SMBMS/jsp/frame.jsp");
        } else {
            req.setAttribute("error", "�û��������벻��ȷӴ��");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            // TODO:��֤frame.jsp�Ƿ�����ȷ��ʾ
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
