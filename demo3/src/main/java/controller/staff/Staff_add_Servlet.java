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

@WebServlet(name = "Staff_add_Servlet", value = "/add_staff")
public class Staff_add_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String path="WEB-INF/views/staff_control/add_staff_control.jsp";

           request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno=request.getParameter("staff_sno_add");
        String sname=request.getParameter("staff_sname_add");
        String ssex=request.getParameter("staff_ssex_add");
        String sage=request.getParameter("staff_sage_add");
        String sedu=request.getParameter("staff_sedu_add");
        String wno=request.getParameter("staff_wno_add");

        Staff staff=new Staff(sno,sname,ssex,sage,sedu,wno);

        StaffDao staffDao=new StaffDao();
        try {
            staffDao.saveStaff(con,staff);
            request.setAttribute("message",staff+"添加成功!");

            List<Staff> allStaff = staffDao.findAllStaff(con);
            request.setAttribute("res",allStaff);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
 //         response.sendRedirect("query_staff");
        String path = "WEB-INF/views/staff_control/staff_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);


    }
}
