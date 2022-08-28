package controller;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "New_user_Servlet", value = "/new_user")
public class New_user_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="WEB-INF/views/new_user.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("user_username_add");
        String password=request.getParameter("user_password_add");

        User user=new User(username,password);
        UserDao userDao=new UserDao();

        try {
            userDao.saveUser(con,user);

            request.setAttribute("message",user+"注册成功");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path="WEB-INF/views/login.jsp";
        request.getRequestDispatcher(path).forward(request,response);

        //response.sendRedirect("query_user");
    }
}

