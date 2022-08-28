package controller;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Update_User_Servlet", value = "/update")
public class Update_User_Servlet extends HttpServlet {
    Connection con=null;
    UserDao userDao=new UserDao();
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
       HttpSession session=request.getSession();

        session.setAttribute("id",id);



        System.out.println("update: "+id);
        try {
            User user=userDao.findById(con,id);
            request.setAttribute("before",user);
            request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session=request.getSession();

        String before_id = (String) session.getAttribute("id");

        System.out.println("response :"+before_id);
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthday=request.getParameter("birthday");
//
//        PrintWriter out = response.getWriter();
        User user=new User(id,username,password,email,gender,birthday);
//        out.println(user);
//
        try {
            userDao.updateUser(con,before_id,user);
            response.sendRedirect("staff");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
