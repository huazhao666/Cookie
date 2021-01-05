package com.example.servlet;

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
 * Time : 18:32
 */
@WebServlet("/getSession")
public class GetSessionServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        if(session == null){
            writer.println("没有登录");
            return;
        }
        String username = (String) session.getAttribute("name");
        String sex = (String) session.getAttribute("sex");
        writer.println(username +":" +  sex);

    }
}
