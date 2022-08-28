package com.example.demo2;

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TryServlet", value = "/try")
public class TryServlet extends HttpServlet {
    Connection con;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //       List<String>test=new ArrayList<>();

//        UserDao userDao=new UserDao();
//        try {
//            test=userDao.findAllusername(con);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        String username = request.getParameter("username");


        request.setAttribute("uername",username);
           request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String test = request.getParameter("test");
        String remember=request.getParameter("remember");

       if(username.equals("admin")){

           if(remember!=null &&  remember.equals("1")){
               Cookie usernameCookies=new Cookie("cusername",username);
               Cookie testCookies=new Cookie("ctest",test);
               Cookie rememberCookies=new Cookie("cremember",remember);
               usernameCookies.setMaxAge(10);
               testCookies.setMaxAge(10);
               rememberCookies.setMaxAge(10);

               response.addCookie(usernameCookies);
               response.addCookie(testCookies);
               response.addCookie(rememberCookies);
           }
           request.setAttribute("username",username);
           request.setAttribute("test",test);
           request.setAttribute("remember",remember);

           request.getRequestDispatcher("t1.jsp").forward(request,response);
       }else{
           request.setAttribute("message","username ERROR!!!");
           response.sendRedirect("try");

       }






    }
}
