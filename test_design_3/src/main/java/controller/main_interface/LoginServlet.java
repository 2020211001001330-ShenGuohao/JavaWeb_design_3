package controller.main_interface;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="WEB-INF/views/login.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean is_exit=false;
        List<User> userList=new ArrayList<>();
//        PrintWriter out = response.getWriter();
//        out.println(username+"*");
//        out.println(password+"*");
        UserDao userDao=new UserDao();
        try {
           userList= userDao.findAllUser(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for(User u:userList){

            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                is_exit=true;
                request.setAttribute("user_1",u);
                break;
            }
        }

        if(is_exit){
            request.getRequestDispatcher("WEB-INF/views/admin_all.jsp").forward(request,response);
        }else {
            request.setAttribute("message","username  or password error");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
        }

    }
}
