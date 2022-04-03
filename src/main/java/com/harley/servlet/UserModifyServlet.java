package com.harley.servlet;

import com.harley.dao.user.UserDao;
import com.harley.dao.user.UserDaoImpl;
import com.harley.pojo.User;
import com.harley.service.UserService;
import com.harley.service.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class UserModifyServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("modify".equals(method)){
            modifyUser(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void modifyUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer uid = Integer.parseInt(req.getParameter("uid"));
        User user = userService.getUserById(uid);
        user.setBirthday(new java.sql.Date(user.getBirthday().getTime()));
        req.setAttribute("user",user);
        req.getRequestDispatcher("/jsp/usermodify.jsp").forward(req, resp);
    }
}
