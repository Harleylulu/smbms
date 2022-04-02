package com.harley.servlet;

import com.alibaba.fastjson.JSONArray;
import com.harley.dao.user.UserDao;
import com.harley.dao.user.UserDaoImpl;
import com.harley.service.UserService;
import com.harley.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class IsUserRoleCodeExistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("ucexist".equals(method)){
            isUserCodeExist(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void isUserCodeExist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode = req.getParameter("userCode");
        Map<String,String> resultMap = new HashMap();
        if(userService.isUserRoleCodeExist(userCode)){
            resultMap.put("userCode", "exist");
        }
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resultMap));
        writer.flush();
        writer.close();
    }
}
