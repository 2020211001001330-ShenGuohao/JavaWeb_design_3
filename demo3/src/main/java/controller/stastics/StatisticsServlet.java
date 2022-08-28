package controller.stastics;

import dao.StaffDao;
import dao.StasticDao;
import model.Client_cal_buy;
import model.Staff;
import model.Stastic;
import model.Warehouse_drag_serplus;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StatisticsServlet", value = "/query_statistics")
public class StatisticsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String path="WEB-INF/views/statistics.jsp";
        StasticDao stasticDao=new StasticDao();
        try {
            List<Stastic> stastics=stasticDao.stastics_cal(con);
            List<Client_cal_buy> client_cal_buys = stasticDao.client_cal_buys(con);

            List<Warehouse_drag_serplus>warehouse1_drag_serpluses=stasticDao.warehouse_drag_serpluses(con,"1");
            List<Warehouse_drag_serplus>warehouse2_drag_serpluses=stasticDao.warehouse_drag_serpluses(con,"2");
            List<Warehouse_drag_serplus>warehouse3_drag_serpluses=stasticDao.warehouse_drag_serpluses(con,"3");



            request.setAttribute("client_buy",client_cal_buys);
            request.setAttribute("stastics",stastics);
            request.setAttribute("serpluses_1",warehouse1_drag_serpluses);
            request.setAttribute("serpluses_2",warehouse2_drag_serpluses);
            request.setAttribute("serpluses_3",warehouse3_drag_serpluses);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
