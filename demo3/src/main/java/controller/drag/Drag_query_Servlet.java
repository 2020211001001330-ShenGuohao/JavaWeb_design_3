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

@WebServlet(name = "Drag_query_Servlet", value = "/query_drag")
public class Drag_query_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="WEB-INF/views/drag_control/drag_control.jsp";

         String Dno="";
         String Dname="";
         String Dsum="";
         String Dprice="";
         String Wno="";


         if(request.getParameter("query_dno")!=null){
             Dno=request.getParameter("query_dno");
         }
         if(request.getParameter("query_dname")!=null){
             Dname=request.getParameter("query_dname");
         }
         if(request.getParameter("query_dsum")!=null){
             Dsum=request.getParameter("query_dsum");
         }
         if(request.getParameter("query_dprice")!=null){
             Dprice=request.getParameter("query_dprice");
         }
         if(request.getParameter("query_wno")!=null){
             Wno=request.getParameter("query_wno");
         }
         Drag query=new Drag(Dno,Dname,Dsum,Dprice,Wno);
         //System.out.println(query+"--------<<<");


         DragDao dragDao=new DragDao();
        try {
            List<Drag> drags=dragDao.findDrag(con,query);
            //System.out.println(drags.size());
            request.setAttribute("res",drags);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
