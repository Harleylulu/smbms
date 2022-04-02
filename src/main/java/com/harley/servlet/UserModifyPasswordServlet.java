package com.harley.servlet;

import com.alibaba.fastjson.JSONArray;
import com.harley.pojo.Role;
import com.harley.pojo.User;
import com.harley.service.RoleService;
import com.harley.service.RoleServiceImpl;
import com.harley.service.UserService;
import com.harley.service.UserServiceImpl;
import com.harley.util.Constants;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserModifyPasswordServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    private RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("savepwd".equals(method)){   //修改密码
            updatePassword(req, resp);
        } else if("pwdmodify".equals(method)){  //旧密码验证
            VerifyOldPassword(req, resp);
        } else if("query".equals(method)){
            queryUser(req,resp);
            //TODO:异步获取？
        } else if("add".equals(method)){
            addUser(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        String newPassword = req.getParameter("newpassword");
        boolean isSuccess = userService.UpdateUserPwd(user.getUserCode(), newPassword);
        if(isSuccess){
            req.setAttribute("message","修改密码成功，请退出后登陆");
            req.getSession().removeAttribute(Constants.USER_SESSION);
        } else {
            // 设置失败
            req.setAttribute("message","修改密码失败");
        }
        req.getRequestDispatcher("/jsp/pwdmodify.jsp").forward(req,resp);
    }

    private void VerifyOldPassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String oldPassword = req.getParameter("oldpassword");//用户输入的密码
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        Map<String,String> resultMap = new HashMap();
        if (oldPassword == null || oldPassword.length() == 0){//输入密码为空
            resultMap.put("result", "error");
        } else if (user == null){//session过期
            resultMap.put("result", "sessionerror");
        } else if (!user.getUserPassword().equals(oldPassword)){
            resultMap.put("result", "false");
        } else {
            resultMap.put("result", "true");
        }

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resultMap));
        writer.flush();
        writer.close();
    }

    private void queryUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取查询结果总数，并传输给前端 totalCount
        String queryName = req.getParameter("queryname");
        String queryUserRole = req.getParameter("queryUserRole");
        Integer queryUserRoleId = 0;
        if(queryUserRole != null){
            queryUserRoleId = Integer.parseInt(queryUserRole);
        }
        int userCount = userService.getUserCount(queryName, queryUserRoleId);
        req.setAttribute("totalCount",userCount);

        // 获取角色列表，并传输给前端 roleList
        List<Role> roleList = roleService.getAllRole();
        req.setAttribute("roleList",roleList);

        // 页面总数
        int totalPageCount = (int)Math.ceil(userCount * 1.0/Constants.PAGE_SIZE);
        req.setAttribute("totalPageCount", totalPageCount);

        // 当前页面
        int currentPageNo = 1;
        String pageIndex = req.getParameter("pageIndex");
        if(pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        currentPageNo=Math.max(currentPageNo, 1);
        currentPageNo=Math.min(currentPageNo, totalPageCount);
        req.setAttribute("currentPageNo", currentPageNo);

        // 获取查询用户结果信息，并传输给前端
        List<User> userList =userService.getUserByNameAndRole(queryName, queryUserRoleId,currentPageNo,Constants.PAGE_SIZE);
        req.setAttribute("userList", userList);

        //查询后的选择框不要发生变化
        req.setAttribute("queryUserName",queryName);
        req.setAttribute("queryUserRole", queryUserRole);

        req.getRequestDispatcher("/jsp/userlist.jsp").forward(req, resp);
    }

    @SneakyThrows
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.builder().userCode(req.getParameter("userCode"))
                .userName(req.getParameter("userName"))
                .userPassword(req.getParameter("userPassword"))
                .gender(Integer.parseInt(req.getParameter("gender")))
                .birthday(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("birthday")))
                .phone(req.getParameter("phone"))
                .address(req.getParameter("address"))
                .userRole(Integer.parseInt(req.getParameter("userRole")))
                .createdBy(((User)req.getSession().getAttribute(Constants.USER_SESSION)).getUserRole()).build();
        userService.addUser(user);

        resp.sendRedirect("/SMBMS/jsp/useradd.jsp");
    }
}