package controller;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

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
        String remember=request.getParameter("remember");
        UserDao userDao=new UserDao();
        User user=null;
        try {
            user=userDao.findByUsernamePassword(con,username,password);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        };


        if(user!=null){
            if(remember!=null && remember.equals("1")){
                Cookie cookie_username=new Cookie("cusername",username);
                Cookie cookie_password=new Cookie("cpassword",password);
                Cookie cookie_remember=new Cookie("cremember",remember);
                cookie_username.setMaxAge(10);
                cookie_password.setMaxAge(10);
                cookie_remember.setMaxAge(10);
                response.addCookie(cookie_username);
                response.addCookie(cookie_password);
                response.addCookie(cookie_remember);
            }
            HttpSession session = request.getSession();

            session.setAttribute("username",user.getUsername());
            String path="WEB-INF/views/main.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        }else{
            String message="username or password ERROR!!!";
            String path="WEB-INF/views/login.jsp";
            request.setAttribute("message",message);

            request.getRequestDispatcher(path).forward(request,response);
        }




    }
}
