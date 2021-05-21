package com.zahar.homework.servlets;
import com.zahar.homework.service.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String uname= req.getParameter("uname");
        String pass= req.getParameter("pass");
        Dao dao= new Dao();

        if(dao.check(uname,pass))
        {
            HttpSession session= req.getSession();
            session.setAttribute("username",uname);
            resp.sendRedirect("table");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }


}
