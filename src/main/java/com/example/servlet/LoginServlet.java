package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if ( session != null ) {
            if(  session.getAttribute("user") != null ) {
                req.getRequestDispatcher("/login.jsp").forward( req , resp );
            } else {
                req.getRequestDispatcher("/user/hello.jsp").forward( req , resp );
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if( req.getParameter("login") != null && req.getParameter("password") != null ) {
           String login = req.getParameter("login");
           String password = req.getParameter("password");

           Users users = Users.getInstance();
           List<String> usersList = users.getUsers();

           if( usersList.contains( login ) && !password.isEmpty() ) {
               HttpSession session = req.getSession();
               if( session != null ) {
                   session.setAttribute("user", login);
                   req.getRequestDispatcher("/user/hello.jsp").forward(req , resp);
               }
           } else  {
               req.getRequestDispatcher("/login.jsp").forward(req , resp);
           }
       }
    }
}
