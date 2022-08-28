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

@WebServlet(name = "Client_delete_Servlet", value = "/delete_client")
public class Client_delete_Servlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delete_client_cno = request.getParameter("delete_client_cno");

        ClientDao clientDao=new ClientDao();
        try {
            Client clientBycno = clientDao.findClientBycno(con, delete_client_cno);

            clientDao.deleteClient(con,delete_client_cno);
            request.setAttribute("message",clientBycno+"删除成功！");

            List<Client> allClient = clientDao.findAllClient(con);
            request.setAttribute("res",allClient);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
     //        response.sendRedirect("query_client");
        String path="WEB-INF/views/client_control/client_control.jsp";

        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
