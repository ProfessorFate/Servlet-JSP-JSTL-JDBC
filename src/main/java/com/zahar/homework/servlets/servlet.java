package com.zahar.homework.servlets;

import com.zahar.homework.data.User;
import com.zahar.homework.service.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/table")
public class servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dao daoBd=new Dao();
        req.setAttribute("usersFromServer",daoBd.getAllUsers());
        RequestDispatcher dispatcher=req.getRequestDispatcher("/table.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id= (Integer.parseInt(req.getParameter("id")));
        String AuthorName=req.getParameter("AuthorName");
        String AuthorLastName=req.getParameter("AuthorLastName");
        String BookName=req.getParameter("BookName");

        Dao daoBd1= new Dao();
        User user= new User(id,AuthorName,AuthorLastName,BookName);
        daoBd1.addUser(user);
        doGet(req,resp);

        }

    }


