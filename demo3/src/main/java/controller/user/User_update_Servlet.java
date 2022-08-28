package controller.user;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "User_update_Servlet", value = "/update_user")
public class User_update_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String update_user_username=request.getParameter("update_user_username");

          request.getSession().setAttribute("before_user_username",update_user_username);

          UserDao userDao=new UserDao();
          String path="WEB-INF/views/super_control/update_super_control.jsp";
          User user=null;
         try {
            user=userDao.findByUsername(con,update_user_username);
          } catch (SQLException throwables) {
            throwables.printStackTrace();
          }
          request.setAttribute("user",user);

          request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String before_user_username= (String) request.getSession().getAttribute("before_user_username");

        String update_username=request.getParameter("user_username_update");
        String update_password=request.getParameter("user_password_update");
        User user=new User(update_username,update_password);
        UserDao userDao=new UserDao();

        try {
            User byUsername = userDao.findByUsername(con, before_user_username);

            userDao.updateUser(con,before_user_username,user);
            request.setAttribute("message",byUsername+"更新成功为:"+user);

            List<User> users=userDao.findAllUser(con);
            request.setAttribute("res",users);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        response.sendRedirect("query_user");
        String path="WEB-INF/views/super_control/super_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
