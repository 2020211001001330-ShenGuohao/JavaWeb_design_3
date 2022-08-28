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

@WebServlet(name = "Warehouse_add_Servlet", value = "/add_warehouse")
public class Warehouse_add_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             String path="WEB-INF/views/warehouse_control/add_warehouse_control.jsp";

             request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String wno=request.getParameter("warehouse_wno_add");
        String wname=request.getParameter("warehouse_wname_add");

        Warehouse warehouse_add=new Warehouse(wno,wname);
        WarehouseDao warehouseDao=new WarehouseDao();
        try {
            warehouseDao.saveWarehouse(con,warehouse_add);
            request.setAttribute("message",warehouse_add+"添加成功");
            List<Warehouse> allWarehouse = warehouseDao.findAllWarehouse(con);
            request.setAttribute("res",allWarehouse);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path="WEB-INF/views/warehouse_control/warehouse_control.jsp";
        request.getRequestDispatcher(path).forward(request,response);

//        response.sendRedirect("query_warehouse");

    }
}
