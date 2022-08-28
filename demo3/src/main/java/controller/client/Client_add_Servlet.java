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

@WebServlet(name = "Client_add_Servlet", value = "/add_client")
public class Client_add_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String path="WEB-INF/views/client_control/add_client_control.jsp";

          request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cno=request.getParameter("client_cno_add");
        String cname=request.getParameter("client_cname_add");
        String ctel=request.getParameter("client_ctel_add");

        Client client=new Client(cno,cname,ctel);
        ClientDao clientDao=new ClientDao();
        try {
            clientDao.saveClient(con,client);
            request.setAttribute("message",client+"添加成功!");
            List<Client> allClient = clientDao.findAllClient(con);
            request.setAttribute("res",allClient);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//         response.sendRedirect("query_client");
        String path="WEB-INF/views/client_control/client_control.jsp";

        request.getRequestDispatcher(path).forward(request,response);

    }
}
