package controller.client;

import dao.ClientDao;
import model.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Client_query_Servlet", value = "/query_client")
public class Client_query_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String path="WEB-INF/views/client_control/client_control.jsp";
            String cno="";
            String cname="";
            String ctel="";
            if(request.getParameter("query_cno")!=null){
                cno=request.getParameter("query_cno");
            }
            if(request.getParameter("query_cname")!=null){
                cname=request.getParameter("query_cname");
            }
            if(request.getParameter("query_ctel")!=null){
                ctel=request.getParameter("query_ctel");
            }
            Client query=new Client(cno,cname,ctel);

            ClientDao clientDao =new ClientDao();

        try {
            List<Client> clients=clientDao.findClient(con,query);
            request.setAttribute("res",clients);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
