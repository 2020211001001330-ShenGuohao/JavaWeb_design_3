package controller.staff;

import dao.StaffDao;
import model.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Staff_query_Servlet", value = "/query_staff")
public class Staff_query_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String path="WEB-INF/views/staff_control/staff_control.jsp";
        String sno="";
        String sname="";
        String ssex="";
        String sage="";
        String sedu="";
        String wno="";

        if(request.getParameter("query_sno")!=null){
            sno=request.getParameter("query_sno");
        }
        if(request.getParameter("query_sname")!=null){
            sname=request.getParameter("query_sname");
        }
        if(request.getParameter("query_ssex")!=null){
            ssex=request.getParameter("query_ssex");
        }
        if(request.getParameter("query_sage")!=null){
            sage=request.getParameter("query_sage");
        }
        if(request.getParameter("query_sedu")!=null){
            sedu=request.getParameter("query_sedu");
        }
        if(request.getParameter("query_wno")!=null){
            wno=request.getParameter("query_wno");
        }
        Staff query=new Staff(sno,sname,ssex,sage,sedu,wno);

        StaffDao staffDao=new StaffDao();

        try {
            List<Staff> staffs=staffDao.findStaff(con,query);
            request.setAttribute("res",staffs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
