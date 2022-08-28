package controller.warehouse;

import dao.WarehouseDao;
import model.Warehouse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Warehouse_delete_Servlet", value = "/delete_warehouse")
public class Warehouse_delete_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delete_warehouse_wno = request.getParameter("delete_warehouse_wno");

        WarehouseDao warehouseDao=new WarehouseDao();

        try {
            Warehouse byWno = warehouseDao.findByWno(con, delete_warehouse_wno);

            warehouseDao.deleteWarehouse(con,delete_warehouse_wno);
            request.setAttribute("message",byWno+"删除成功!");

            List<Warehouse> allWarehouse = warehouseDao.findAllWarehouse(con);
            request.setAttribute("res",allWarehouse);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        response.sendRedirect("query_warehouse");
        String path="WEB-INF/views/warehouse_control/warehouse_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
