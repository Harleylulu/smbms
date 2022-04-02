package com.harley.servlet;

import com.alibaba.fastjson.JSONArray;
import com.harley.pojo.Role;
import com.harley.service.RoleService;
import com.harley.service.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetRoleServlet extends HttpServlet {

    RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("getrolelist".equals(method)){
            getRoleList(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void getRoleList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> roleList = roleService.getAllRole();
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(roleList));
        writer.flush();
        writer.close();
    }
}
