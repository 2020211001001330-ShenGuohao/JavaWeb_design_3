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

@WebServlet(name = "Orderd_add_Servlet", value = "/add_orderd")
public class Orderd_add_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String path="WEB-INF/views/orderd_control/add_orderd_control.jsp";

         request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderd_ono_add = request.getParameter("orderd_ono_add");
        String orderd_dno_add = request.getParameter("orderd_dno_add");
        String orderd_cno_add = request.getParameter("orderd_cno_add");
        String orderd_osum = request.getParameter("orderd_osum_add");
        String orderd_ctel_add = request.getParameter("orderd_bdate_add");

        Orderd orderd=new Orderd(orderd_ono_add,orderd_dno_add,orderd_cno_add,orderd_osum,orderd_ctel_add);

        OrderdDao orderdDao=new OrderdDao();
        try {
            orderdDao.saveOrderd(con,orderd);
            request.setAttribute("message",orderd+"添加成功!");
            List<Orderd> allOrder = orderdDao.findAllOrder(con);
            request.setAttribute("res",allOrder);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
  //       response.sendRedirect("query_orderd");
        String path = "WEB-INF/views/orderd_control/orderd_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }
}
