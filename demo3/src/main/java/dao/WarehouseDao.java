package dao;

import model.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDao implements IWarehoueDao{
    @Override
    public List<Warehouse> findAllWarehouse(Connection con) throws SQLException {
        String sql="select * from warehouse";
        PreparedStatement st = con.prepareStatement(sql);
        List<Warehouse> warehouses=new ArrayList<>();
        ResultSet res = st.executeQuery();
        while (res.next()){
            Warehouse warehouse=new Warehouse();
            warehouse.setWno(res.getString("wno"));
            warehouse.setWname(res.getString("wname"));
            warehouses.add(warehouse);
        }
        return warehouses;
    }

    @Override
    public boolean saveWarehouse(Connection con, Warehouse warehouse) throws SQLException {

        String sql =" insert into warehouse values(?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, warehouse.getWno());
        st.setString(2,warehouse.getWname());
        st.executeUpdate();
        return true;
    }

    @Override
    public int deleteWarehouse(Connection con, String wno) throws SQLException {
        String sql="delete warehouse where wno=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,wno);
        st.executeUpdate();
        return 1;
    }

    @Override
    public int updateWarehouse(Connection con, String wno, Warehouse warehouse) throws SQLException {
        String sql="update warehouse set wno=?,wname=? where wno=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,warehouse.getWno());
        st.setString(2,warehouse.getWname());
        st.setString(3,wno);
        st.executeUpdate();
        return 1;
    }

    @Override
    public Warehouse findByWno(Connection con, String wno) throws SQLException {

        String sql="SELECT * FROM warehouse WHERE wno=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,wno);

        ResultSet res = st.executeQuery();
        Warehouse warehouse=new Warehouse();
        while (res.next()){
            warehouse.setWno(res.getString("wno"));
            warehouse.setWname(res.getString("wname"));
        }


        return warehouse;
    }

    @Override
    public List<Warehouse> findWarehouse(Connection con, Warehouse query) throws SQLException {

        String sql="select * from warehouse where 1=1";

        if(query.getWno().length()!=0){
            sql+=" and wno like ?";
        }

        if(query.getWname().length()!=0){
            sql+=" and wname like ?";
        }

        int index=1;
        PreparedStatement st = con.prepareStatement(sql);
        List<Warehouse> warehouses=new ArrayList<>();

        if(query.getWno().length()!=0){
             st.setString(index++,"%"+query.getWno()+"%");
        }
        if(query.getWname().length()!=0){
            st.setString(index++,"%"+query.getWname()+"%");
        }

        ResultSet res = st.executeQuery();
        while (res.next()){
            Warehouse warehouse=new Warehouse();
            warehouse.setWno(res.getString("wno"));
            warehouse.setWname(res.getString("wname"));
            warehouses.add(warehouse);
        }


        return warehouses;
    }
}
