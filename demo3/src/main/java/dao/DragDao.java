package dao;

import model.Drag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DragDao implements IDragDao{
    @Override
    public List<Drag> findAllDrag(Connection con) throws SQLException {
        String sql="select * from drag";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet res = st.executeQuery();
        List<Drag> drags=new ArrayList<>();
        while (res.next()){
            Drag drag=new Drag();
            drag.setDno(res.getString("Dno"));
            drag.setDname(res.getString("Dname"));
            drag.setDsum(res.getString("Dsum"));
            drag.setDprice(res.getString("Dprice"));
            drag.setWno(res.getString("Wno"));

            drags.add(drag);
        }



        return drags;


    }

    @Override
    public boolean saveDrag(Connection con, Drag drag) throws SQLException {
        String sql="insert into drag values(?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,drag.getDno());
        st.setString(2,drag.getDname());
        st.setString(3,drag.getDsum());
        st.setString(4, drag.getDprice());
        st.setString(5,drag.getWno());

        st.executeUpdate();


        return true;
    }

    @Override
    public int deleteDrag(Connection con, String Dno) throws SQLException {
        String sql="delete drag where Dno=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,Dno);
        st.executeUpdate();

        return 1;
    }

    @Override
    public int updateDrag(Connection con, String Dno, Drag drag) throws SQLException {

        String sql="update drag set Dno=?,Dname=?,Dsum=?,Dprice=?,Wno=? where Dno=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, drag.getDno());
        st.setString(2,drag.getDname());
        st.setString(3,drag.getDsum());
        st.setString(4,drag.getDprice());
        st.setString(5,drag.getWno());
        st.setString(6,Dno);
        st.executeUpdate();
        return 1;
    }

    @Override
    public List<Drag> findDrag(Connection con, Drag query) throws SQLException {


        String sql="select * from drag where 1=1";

        if(query.getDno().length()!=0){
            sql+=" and Dno LIKE ?";
        }
        if(query.getDname().length()!=0){
            sql+=" and Dname LIKE ?";
        }
        if(query.getDsum().length()!=0){
            sql+=" and Dsum= ?";
        }
        if(query.getDprice().length()!=0){
            sql+=" and Dprice= ?";
        }
        if(query.getWno().length()!=0){
            sql+=" and Wno like ?";
        }

        System.out.println(sql);

        List<Drag> drags=new ArrayList<>();
        PreparedStatement st = con.prepareStatement(sql);
        int index=1;
        if(query.getDno().length()!=0){
            st.setString(index++,"%"+query.getDno()+"%");
        }
        if(query.getDname().length()!=0){
            st.setString(index++,"%"+query.getDname()+"%");
        }
        if(query.getDsum().length()!=0){
            st.setString(index++,query.getDsum());
        }
        if(query.getDprice().length()!=0){
            st.setString(index++,query.getDprice());
        }
        if(query.getWno().length()!=0){
            st.setString(index++,"%"+query.getWno()+"%");
        }

        ResultSet res = st.executeQuery();
        while (res.next()){
            Drag drag=new Drag();
            drag.setDno(res.getString("Dno"));
            drag.setDname(res.getString("Dname"));
            drag.setDsum(res.getString("Dsum"));
            drag.setDprice(res.getString("Dprice"));
            drag.setWno(res.getString("Wno"));

            drags.add(drag);
        }



        return drags;

    }

    @Override
    public Drag findByDno(Connection con, String Dno) throws SQLException {

        String sql="select * from drag where Dno=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,Dno);
        ResultSet res=st.executeQuery();
        Drag drag=new Drag();

        while (res.next()){
            drag.setDno(res.getString(1));
            drag.setDname(res.getString(2));
            drag.setDsum(res.getString(3));
            drag.setDprice(res.getString(4));
            drag.setWno(res.getString(5));
        }


        return drag;
    }
}
