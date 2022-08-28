package controller.user;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "User_add_Servlet", value = "/add_user")
public class User_add_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="WEB-INF/views/super_control/add_super_control.jsp";
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
            List<User> users=userDao.findAllUser(con);
            request.setAttribute("message",user+"添加成功");
            request.setAttribute("res",users);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
          String path="WEB-INF/views/super_control/super_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);

        //response.sendRedirect("query_user");
    }
}
