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

@WebServlet(name = "Drag_delete_Servlet", value = "/delete_drag")
public class Drag_delete_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delete_drag_dno = request.getParameter("delete_drag_dno");
        DragDao dragDao = new DragDao();
        try {
            Drag byDno = dragDao.findByDno(con, delete_drag_dno);
            dragDao.deleteDrag(con,delete_drag_dno);

            request.setAttribute("message",byDno+"删除成功!");
            List<Drag> allDrag = dragDao.findAllDrag(con);
            request.setAttribute("res",allDrag);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
     //   response.sendRedirect("query_drag");
        String path = "WEB-INF/views/drag_control/drag_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
