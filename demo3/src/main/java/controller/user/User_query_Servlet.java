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

@WebServlet(name = "User_query_Servlet", value = "/query_user")
public class User_query_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="WEB-INF/views/super_control/super_control.jsp";
        String username="";
        String password="";

        if(request.getParameter("query_username")!=null){
            username=request.getParameter("query_username");
        }
        if(request.getParameter("query_password")!=null){
            password=request.getParameter("query_password");
        }

/*        System.out.println(username+"***");
        System.out.println(password+"***");*/

        User query=new User(username,password);
        UserDao userDao=new UserDao();
        System.out.println(query+"<<---query----");
        try {
            List<User> userList=userDao.findUser(con,query);
            request.setAttribute("res",userList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
