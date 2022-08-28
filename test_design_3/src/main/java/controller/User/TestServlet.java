package controller.User;

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
import java.util.List;

@WebServlet(name = "TestServlet", value = "/test")
public class TestServlet extends HttpServlet {

    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id="";
        String username="";
        String password="";
        String email="";
        String gender="";
        String birthday="";

        if(request.getParameter("l_id")!=null){
            id=request.getParameter("l_id");
        }
        if(request.getParameter("l_username")!=null){
            username=request.getParameter("l_username");
        }
        if(request.getParameter("l_password")!=null){
            password=request.getParameter("l_password");
        }
        if(request.getParameter("l_email")!=null){
            email=request.getParameter("l_email");
        }
        if(request.getParameter("l_gender")!=null){
            gender=request.getParameter("l_gender");
        }
        if(request.getParameter("l_birthday")!=null){
            birthday=request.getParameter("l_birthday");
        }



        System.out.println(id+"*");
        System.out.println(username+"*");
        System.out.println(password+"*");
        System.out.println(email+"*");
        System.out.println(gender+"*");
        System.out.println(birthday+"*");

        User query =new User(id,username,password,email,gender,birthday);
        System.out.println(query+"<<-------");
        UserDao userDao=new UserDao();

        try {
            List<User> userList=userDao.findUser(con,query);
            request.setAttribute("res",userList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



          request.getRequestDispatcher("WEB-INF/views/userList.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
