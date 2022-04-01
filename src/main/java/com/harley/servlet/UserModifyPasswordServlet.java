package com.harley.servlet;

import com.alibaba.fastjson.JSONArray;
import com.harley.pojo.User;
import com.harley.service.UserService;
import com.harley.service.UserServiceImpl;
import com.harley.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserModifyPasswordServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("savepwd".equals(method)){   //�޸�����
            updatePassword(req, resp);
        } else if("pwdmodify".equals(method)){  //��������֤
            VerifyOldPassword(req, resp);
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
            req.setAttribute("message","�޸�����ɹ������˳����½");
            req.getSession().removeAttribute(Constants.USER_SESSION);
        } else {
            // ����ʧ��
            req.setAttribute("message","�޸�����ʧ��");
        }
        req.getRequestDispatcher("/jsp/pwdmodify.jsp").forward(req,resp);
    }

    private void VerifyOldPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldpassword");//�û����������
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        Map<String,String> resultMap = new HashMap();
        if (oldPassword == null || oldPassword.length() == 0){//��������Ϊ��
            resultMap.put("result", "error");
        } else if (user == null){//session����
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
}
