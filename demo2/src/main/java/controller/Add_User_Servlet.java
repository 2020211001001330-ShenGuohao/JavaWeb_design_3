package controller;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Add_User_Servlet", value = "/add")
public class Add_User_Servlet extends HttpServlet {

    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="WEB-INF/views/addUser.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthday=request.getParameter("birthday");
        System.out.println(id+"*_add");
        System.out.println(username+"*_add");
        System.out.println(password+"*_add");
        System.out.println(email+"*_add");
        System.out.println(gender+"*_add");
        System.out.println(birthday+"*_add");
        User user=new User(id,username,password,email,gender,birthday);
//        PrintWriter out = response.getWriter();
//        out.println(user);
        UserDao userDao=new UserDao();
        response.sendRedirect("staff");
        try {
            userDao.saveUser(con,user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
