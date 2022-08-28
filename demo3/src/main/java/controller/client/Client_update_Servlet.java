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

@WebServlet(name = "Client_update_Servlet", value = "/update_client")
public class Client_update_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="WEB-INF/views/client_control/update_client_control.jsp";
        String update_client_cno = request.getParameter("update_client_cno");
        request.getSession().setAttribute("update_client_cno",update_client_cno);

        Client client=new Client();
        ClientDao clientDao=new ClientDao();

        try {
            client=clientDao.findClientBycno(con,update_client_cno);
            request.setAttribute("client",client);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String update_client_cno = (String) request.getSession().getAttribute("update_client_cno");

        String client_cno_update = request.getParameter("client_cno_update");
        String client_cname_update = request.getParameter("client_cname_update");
        String client_ctel_update = request.getParameter("client_ctel_update");
        Client client=new Client(client_cno_update,client_cname_update,client_ctel_update);
        ClientDao clientDao=new ClientDao();
        try {
            Client clientBycno = clientDao.findClientBycno(con, update_client_cno);

            clientDao.updateClient(con,update_client_cno,client);
            request.setAttribute("message",clientBycno+"成功更新为:"+client);
            List<Client> allClient = clientDao.findAllClient(con);
            request.setAttribute("res",allClient);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    //    response.sendRedirect("query_client");
        String path="WEB-INF/views/client_control/client_control.jsp";

        request.getRequestDispatcher(path).forward(request,response);
    }
}
