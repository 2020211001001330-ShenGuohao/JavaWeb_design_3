package controller.orderd;

import dao.OrderdDao;
import model.Orderd;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Orderd_delete_Servlet", value = "/delete_orderd")
public class Orderd_delete_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delete_orderd_ono = request.getParameter("delete_orderd_ono");
        OrderdDao orderdDao=new OrderdDao();
        try {
            Orderd orderdByOno = orderdDao.findOrderdByOno(con, delete_orderd_ono);
            orderdDao.deleteOrderd(con,delete_orderd_ono);
            request.setAttribute("message",orderdByOno+"删除成功!");
            List<Orderd> allOrder = orderdDao.findAllOrder(con);
            request.setAttribute("res",allOrder);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
 //           response.sendRedirect("query_orderd");
        String path = "WEB-INF/views/orderd_control/orderd_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
