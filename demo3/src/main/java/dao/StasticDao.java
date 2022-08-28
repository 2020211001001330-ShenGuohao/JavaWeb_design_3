package dao;

import jdk.nashorn.internal.ir.CallNode;
import model.Client_cal_buy;
import model.Stastic;
import model.Warehouse_drag_serplus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StasticDao {

   public List<Stastic> stastics_cal(Connection con) throws SQLException{

       String sql="SELECT A1.Wno,Salesum,Saleprice,PreSum-Salesum Serplus\n" +
               " FROM\n" +
               " \n" +
               "(SELECT  Wno ,SUM(Dsum) PreSum    \n" +
               "FROM drag\n" +
               "Group by Wno )AS A1(Wno,PreSum),\n" +
               "\n" +
               "(SELECT Wno,SUM(Osum) Salesum,SUM(Dprice*Osum) Saleprice\n" +
               "FROM drag,Orderd \n" +
               "WHERE drag.Dno=Orderd.Dno \n" +
               "GROUP By Wno) AS A2(Wno,Salesum,Saleprice)\n" +
               "\n" +
               "WHERE A1.Wno=A2.Wno\n";

       PreparedStatement st = con.prepareStatement(sql);
       ResultSet res = st.executeQuery();
       List<Stastic> stastics=new ArrayList<>();
       while (res.next()){
           Stastic stastic=new Stastic();
           stastic.setWno(res.getString("wno"));
           stastic.setSalesum(res.getString("salesum"));
           stastic.setSaleprice(res.getString("saleprice"));
           stastic.setSerplus(res.getString("serplus"));
           stastics.add(stastic);
       }

       return stastics;
   }

   public List<Client_cal_buy> client_cal_buys(Connection con) throws SQLException{

       String sql="SELECT client.Cname ,sum(Osum*drag.Dprice) buy_sum\n" +
               "FROM Client,Orderd,Drag\n" +
               "WHERE client.Cno=Orderd.Cno and Orderd.Dno=drag.Dno\n" +
               "GROUP BY client.Cno,client.Cname";
       PreparedStatement st = con.prepareStatement(sql);

       ResultSet res = st.executeQuery();
       List<Client_cal_buy> client_cal_buys=new ArrayList<>();
       while (res.next()){
           Client_cal_buy client_cal_buy=new Client_cal_buy();
           client_cal_buy.setCname(res.getString("cname"));
           client_cal_buy.setBuy_sum(res.getString("buy_sum"));
           client_cal_buys.add(client_cal_buy);
       }
       return client_cal_buys;
   }

   public List<Warehouse_drag_serplus> warehouse_drag_serpluses(Connection con,String wno)throws SQLException{

       String sql="SELECT A1.wno,A1.dname,A1.dsum-A1.salesum serplus\n" +
               "FROM\n" +
               "(SELECT drag.Dno,drag.Dname,drag.Wno,drag.Dsum,SUM(Orderd.Osum)as salesum\n" +
               "FROM Orderd,drag\n" +
               "WHERE Orderd.Dno=drag.Dno \n" +
               "GROUP BY drag.Dno,drag.Dname,drag.Wno,drag.Dsum) AS A1(dno,dname,wno,dsum,salesum)\n" +
               "WHERE Wno=?";
       PreparedStatement st = con.prepareStatement(sql);
       st.setString(1,wno);
       ResultSet res = st.executeQuery();
       List<Warehouse_drag_serplus>warehouse_drag_serpluses=new ArrayList<>();
       while (res.next()){
           Warehouse_drag_serplus warehouse_drag_serplus=new Warehouse_drag_serplus();

           warehouse_drag_serplus.setWno(res.getString("wno"));
           warehouse_drag_serplus.setDname(res.getString("dname"));
           warehouse_drag_serplus.setSerplus(res.getString("serplus"));
           warehouse_drag_serpluses.add(warehouse_drag_serplus);
       }

       return warehouse_drag_serpluses;
   }

}
