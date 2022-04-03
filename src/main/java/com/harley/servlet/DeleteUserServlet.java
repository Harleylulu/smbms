package com.harley.servlet;

import com.alibaba.fastjson.JSONArray;
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

public class DeleteUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("deluser".equals(method)){
            deleteUserById(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void deleteUserById(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        Integer uid = Integer.parseInt(req.getParameter("uid"));
        int result = userService.delUserById(uid);
        Map<String,String> resultMap = new HashMap();
        if(result>0){
            resultMap.put("delResult","true");
        } else {
            resultMap.put("delResult","false");
        }
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resultMap));
        writer.flush();
        writer.close();

    }
}
