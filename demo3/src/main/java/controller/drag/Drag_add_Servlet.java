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

@WebServlet(name = "Drag_add_Servlet", value = "/add_drag")
public class Drag_add_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String path="WEB-INF/views/drag_control/add_drag_control.jsp";
            request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Dno=request.getParameter("drag_dno_add");
        String Dname=request.getParameter("drag_dname_add");
        String Dsum=request.getParameter("drag_dsum_add");
        String Dprice=request.getParameter("drag_dprice_add");
        String Wno=request.getParameter("drag_wno_add");

        Drag drag=new Drag(Dno,Dname,Dsum,Dprice,Wno);
        DragDao dragDao = new DragDao();
        try {
            dragDao.saveDrag(con,drag);

            request.setAttribute("message",drag+"添加成功!");
            List<Drag> allDrag = dragDao.findAllDrag(con);
            request.setAttribute("res",allDrag);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
 //         response.sendRedirect("query_drag");
        String path = "WEB-INF/views/drag_control/drag_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }
}
