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

@WebServlet(name = "User_delete_Servlet", value = "/delete_user")
public class User_delete_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delete_user_username=request.getParameter("delete_user_username");
        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsername(con,delete_user_username);
            userDao.deleteUser(con,delete_user_username);
            List<User> users=userDao.findAllUser(con);
            request.setAttribute("message",user+"删除成功");
            request.setAttribute("res",users);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path="WEB-INF/views/super_control/super_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
       // response.sendRedirect("query_user");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
