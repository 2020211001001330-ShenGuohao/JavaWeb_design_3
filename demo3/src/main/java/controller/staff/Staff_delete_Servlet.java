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

@WebServlet(name = "Staff_delete_Servlet", value = "/delete_staff")
public class Staff_delete_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delete_staff_sno = request.getParameter("delete_staff_sno");

        StaffDao staffDao=new StaffDao();

        try {
            Staff staffBySno = staffDao.findStaffBySno(con, delete_staff_sno);
            staffDao.deleteStaff(con,delete_staff_sno);
            request.setAttribute("message",staffBySno+"删除成功!");
            List<Staff> allStaff = staffDao.findAllStaff(con);
            request.setAttribute("res",allStaff);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // response.sendRedirect("query_staff");
        String path = "WEB-INF/views/staff_control/staff_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
