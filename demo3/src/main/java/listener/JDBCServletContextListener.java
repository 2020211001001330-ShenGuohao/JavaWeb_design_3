package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //设置编码方式
        sce.getServletContext().setRequestCharacterEncoding("utf-8");

        ServletContext context=sce.getServletContext();
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        String url=context.getInitParameter("url");
        String driver=context.getInitParameter("driver");

        try {
            Class.forName(driver);
          Connection con= DriverManager.getConnection(url,username,password);
          context.setAttribute("con",con);
          System.out.println("JDBCServletContextListener:contextInitialized()-->con:"+con);


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         sce.getServletContext().removeAttribute("con");
         System.out.println("JDBCServletContextListener:contextDestroyed()");
    }

}
