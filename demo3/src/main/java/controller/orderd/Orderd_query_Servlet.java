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

@WebServlet(name = "Orderd_query_Servlet", value = "/query_orderd")
public class Orderd_query_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String path="WEB-INF/views/orderd_control/orderd_control.jsp";

          String Ono="";
          String Dno="";
          String Cno="";
          String Osum="";
          String Bdate="";

          if(request.getParameter("query_ono")!=null){
              Ono=request.getParameter("query_ono");
          }
          if(request.getParameter("query_dno")!=null){
              Dno=request.getParameter("query_dno");
          }
          if(request.getParameter("query_cno")!=null){
              Cno=request.getParameter("query_cno");
          }
          if(request.getParameter("query_osum")!=null){
              Osum=request.getParameter("query_osum");
          }
          if(request.getParameter("query_bdate")!=null){
              Bdate=request.getParameter("query_bdate");
          }

          Orderd query=new Orderd(Ono,Dno,Cno,Osum,Bdate);
          //System.out.println("---->>>>>"+query);
          OrderdDao orderdDao=new OrderdDao();

        try {
            List<Orderd> orderds =orderdDao.findOrder(con,query);
            request.setAttribute("res",orderds);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
