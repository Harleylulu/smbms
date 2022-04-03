package com.harley.servlet;

import com.harley.pojo.User;
import com.harley.service.UserService;
import com.harley.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewUserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("view".equals(method)){
            viewUser(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void viewUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        User user = userService.getUserById(Integer.parseInt(uid));

        req.setAttribute("user",user);
        req.getRequestDispatcher("/jsp/userview.jsp").forward(req, resp);
    }
}
