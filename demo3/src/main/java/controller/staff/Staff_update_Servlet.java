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

@WebServlet(name = "Staff_update_Servlet", value = "/update_staff")
public class Staff_update_Servlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
         super.init();
         con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String path="WEB-INF/views/staff_control/update_staff_control.jsp";
        String update_staff_sno = request.getParameter("update_staff_sno");

        request.getSession().setAttribute("update_staff_sno",update_staff_sno);

        Staff staff=new Staff();
        StaffDao staffDao=new StaffDao();
        try {
            staff=staffDao.findStaffBySno(con,update_staff_sno);
//            System.out.println("----->>>>>>"+staff);
            request.setAttribute("staff",staff);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String update_staff_sno = (String) request.getSession().getAttribute("update_staff_sno");
        String staff_sno= request.getParameter("staff_sno_update");
        String staff_sname = request.getParameter("staff_sname_update");
        String staff_ssex = request.getParameter("staff_ssex_update");
        String staff_sage=request.getParameter("staff_sage_update");
        String staff_sedu = request.getParameter("staff_sedu_update");
        String staff_wno = request.getParameter("staff_wno_update");
        Staff staff=new Staff(staff_sno,staff_sname,staff_ssex,staff_sage,staff_sedu,staff_wno);

        StaffDao staffDao=new StaffDao();
        try {
            Staff staffBySno = staffDao.findStaffBySno(con, update_staff_sno);
            staffDao.updateStaff(con,update_staff_sno,staff);
            request.setAttribute("message",staffBySno+"成功更新为: "+staff);
            List<Staff> allStaff = staffDao.findAllStaff(con);
            request.setAttribute("res",allStaff);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        response.sendRedirect("query_staff");
        String path = "WEB-INF/views/staff_control/staff_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
