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

@WebServlet(name = "Warehouse_query_Servlet", value = "/query_warehouse")
public class Warehouse_query_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path="WEB-INF/views/warehouse_control/warehouse_control.jsp";
        String wno="";
        String wname="";

        if(request.getParameter("query_wno")!=null){
            wno=request.getParameter("query_wno");
        }
        if(request.getParameter("query_wname")!=null){
            wname=request.getParameter("query_wname");
        }
        Warehouse query=new Warehouse(wno,wname);
        WarehouseDao warehouseDao=new WarehouseDao();


        try {
            List<Warehouse>warehouses=warehouseDao.findWarehouse(con,query);
            request.setAttribute("res",warehouses);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
