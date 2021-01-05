package com.example.servlet;

import com.example.dao.Login;
import com.example.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-05
 * Time : 17:40
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        User user = Login.queryDAO(username);
        if(user == null){
            writer.println("用户不存在");
        }else {
            if(!user.getPassword().equals(password)){
                writer.println("用户名或者密码错误");
            }else {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user",user);
                resp.sendRedirect("/again");
                writer.println("登录成功");
            }
        }
    }
}
