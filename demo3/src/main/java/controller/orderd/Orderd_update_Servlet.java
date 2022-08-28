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

@WebServlet(name = "Orderd_update_Servlet", value = "/update_orderd")
public class Orderd_update_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="WEB-INF/views/orderd_control/update_orderd_control.jsp";
        String update_orderd_ono = request.getParameter("update_orderd_ono");

        request.getSession().setAttribute("update_orderd_ono",update_orderd_ono);
        Orderd orderd=new Orderd();

        OrderdDao orderdDao=new OrderdDao();
        try {
            orderd=orderdDao.findOrderdByOno(con,update_orderd_ono);
            request.setAttribute("orderd",orderd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ono_before= (String) request.getSession().getAttribute("update_orderd_ono");

        String orderd_ono_update = request.getParameter("orderd_ono_update");
        String orderd_dno_update = request.getParameter("orderd_dno_update");
        String orderd_cno_update = request.getParameter("orderd_cno_update");
        String orderd_osum_update = request.getParameter("orderd_osum_update");
        String orderd_bdate_update = request.getParameter("orderd_bdate_update");

        Orderd orderd=new Orderd(orderd_ono_update,orderd_dno_update,orderd_cno_update,orderd_osum_update,orderd_bdate_update);

        OrderdDao orderdDao=new OrderdDao();
        try {
            Orderd orderdByOno = orderdDao.findOrderdByOno(con, ono_before);
            orderdDao.updateOrderd(con,ono_before,orderd);
            request.setAttribute("message",orderdByOno+"成功更新为: "+orderd);
            List<Orderd> allOrder = orderdDao.findAllOrder(con);
            request.setAttribute("res",allOrder);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
     //   response.sendRedirect("query_orderd");
        String path = "WEB-INF/views/orderd_control/orderd_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
