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

@WebServlet(name = "Warehouse_update_Servlet", value = "/update_warehouse")
public class Warehouse_update_Servlet extends HttpServlet {

    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String warehouse_update_before_wno=request.getParameter("update_warehouse_wno");
        request.getSession().setAttribute("before_warehouse_wno",warehouse_update_before_wno);
        String path="WEB-INF/views/warehouse_control/update_warehouse.jsp";
        Warehouse warehouse=new Warehouse();

        WarehouseDao warehouseDao=new WarehouseDao();
        try {
            warehouse=warehouseDao.findByWno(con,warehouse_update_before_wno);
            request.setAttribute("warehouse_update",warehouse);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String warehouse_wno_update = request.getParameter("warehouse_wno_update");
        String warehouse_wname_update = request.getParameter("warehouse_wname_update");

        String before_warehouse_wno = (String) request.getSession().getAttribute("before_warehouse_wno");

        Warehouse warehouse_update=new Warehouse(warehouse_wno_update,warehouse_wname_update);

        WarehouseDao warehouseDao=new WarehouseDao();
        try {
            Warehouse byWno = warehouseDao.findByWno(con, before_warehouse_wno);

            warehouseDao.updateWarehouse(con,before_warehouse_wno,warehouse_update);
            request.setAttribute("message",byWno+"成功更新为: "+warehouse_update);

            List<Warehouse> allWarehouse = warehouseDao.findAllWarehouse(con);
            request.setAttribute("res",allWarehouse);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //response.sendRedirect("query_warehouse");
        String path="WEB-INF/views/warehouse_control/warehouse_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
