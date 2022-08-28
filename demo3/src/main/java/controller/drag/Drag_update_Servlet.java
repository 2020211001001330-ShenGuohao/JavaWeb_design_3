package controller.drag;

import dao.DragDao;
import model.Drag;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Drag_update_Servlet", value = "/update_drag")
public class Drag_update_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String update_drag_dno=request.getParameter("update_drag_dno");
        request.getSession().setAttribute("before_drag_dno",update_drag_dno);

        DragDao dragDao=new DragDao();
        Drag drag =new Drag();
        String path="WEB-INF/views/drag_control/update_drag_control.jsp";


        try {
            drag=dragDao.findByDno(con,update_drag_dno);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("update_drag",drag);
        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String before_Dno= (String) request.getSession().getAttribute("before_drag_dno");

        String Dno=request.getParameter("drag_dno_update");
        String Dname=request.getParameter("drag_dname_update");
        String Dsum=request.getParameter("drag_dsum_update");
        String Dprice=request.getParameter("drag_dprice_update");
        String Wno=request.getParameter("drag_wno_update");

        Drag drag_update =new Drag(Dno,Dname,Dsum,Dprice,Wno);
        System.out.println("update_Dno"+ before_Dno+" "+drag_update);
        DragDao dragDao =new DragDao();

        try {
            Drag byDno = dragDao.findByDno(con, before_Dno);
            dragDao.updateDrag(con,before_Dno,drag_update);

            request.setAttribute("message",byDno+"成功更新为:"+drag_update);
            List<Drag> allDrag = dragDao.findAllDrag(con);
            request.setAttribute("res",allDrag);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        response.sendRedirect("query_drag");
        String path = "WEB-INF/views/drag_control/drag_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
