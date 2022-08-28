package dao;

import model.Orderd;
import sun.plugin2.message.CookieReplyMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderdDao implements IOrderdDao{
    @Override
    public List<Orderd> findAllOrder(Connection con) throws SQLException {
        String sql="select * from orderd";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet res = st.executeQuery();
        List<Orderd> orderds=new ArrayList<>();
        while (res.next()){
            Orderd orderd=new Orderd();
            orderd.setOno(res.getString("ono"));
            orderd.setDno(res.getString("dno"));
            orderd.setCno(res.getString("cno"));
            orderd.setOsum(res.getString("osum"));
            orderd.setBdate(res.getString("bdate"));
            orderds.add(orderd);
        }

        return orderds;
    }

    @Override
    public boolean saveOrderd(Connection con, Orderd orderd) throws SQLException {
        String sql="insert into orderd values(?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,orderd.getOno());
        st.setString(2,orderd.getDno());
        st.setString(3,orderd.getCno());
        st.setString(4,orderd.getOsum());
        st.setString(5,orderd.getBdate());

        st.executeUpdate();
        return true;

    }

    @Override
    public int deleteOrderd(Connection con, String ono) throws SQLException {
        String sql="delete orderd where ono=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,ono);

        st.executeUpdate();


        return 1;
    }

    @Override
    public int updateOrderd(Connection con, String ono, Orderd orderd) throws SQLException {
        String sql="update orderd set ono=?,dno=?,cno=?,osum=?,bdate=? where ono=?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,orderd.getOno());
        st.setString(2,orderd.getDno());
        st.setString(3,orderd.getCno());
        st.setString(4,orderd.getOsum());
        st.setString(5,orderd.getBdate());
        st.setString(6,ono);

        st.executeUpdate();

        return 1;
    }

    @Override
    public Orderd findOrderdByOno(Connection con, String ono) throws SQLException {
        String sql="select * from orderd where ono=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,ono);
        ResultSet res = st.executeQuery();
        Orderd orderd=new Orderd();
        while (res.next()){
            orderd.setOno(res.getString("ono"));
            orderd.setDno(res.getString("dno"));
            orderd.setCno(res.getString("cno"));
            orderd.setOsum(res.getString("osum"));
            orderd.setBdate(res.getString("bdate"));
        }


        return orderd;
    }

    @Override
    public List<Orderd> findOrder(Connection con, Orderd query) throws SQLException {

        String sql="select * from orderd where 1=1";

        if(query.getOno().length()!=0){
            sql+=" and ono like ?";
        }
        if(query.getDno().length()!=0){
            sql+=" and dno like ?";
        }
        if(query.getCno().length()!=0){
            sql+=" and cno like ?";
        }
        if(query.getOsum().length()!=0){
            sql+=" and osum =?";
        }
        if(query.getBdate().length()!=0){
            sql+=" and bdate like ?";
        }
        int index=1;
        PreparedStatement st = con.prepareStatement(sql);
        if(query.getOno().length()!=0){
            st.setString(index++,"%"+query.getOno()+"%");
        }
        if(query.getDno().length()!=0){
            st.setString(index++,"%"+query.getDno()+"%");
        }
        if(query.getCno().length()!=0){
            st.setString(index++,"%"+query.getCno()+"%");
        }
        if(query.getOsum().length()!=0){
            st.setString(index++,query.getOsum());
        }
        if(query.getBdate().length()!=0){
            st.setString(index++,"%"+query.getBdate()+"%");
        }

        ResultSet res = st.executeQuery();
        List<Orderd> orderds=new ArrayList<>();
        while (res.next()){
            Orderd orderd=new Orderd();
            orderd.setOno(res.getString("ono"));
            orderd.setDno(res.getString("dno"));
            orderd.setCno(res.getString("cno"));
            orderd.setOsum(res.getString("osum"));
            orderd.setBdate(res.getString("bdate"));
            orderds.add(orderd);
        }

        return orderds;
    }
}
