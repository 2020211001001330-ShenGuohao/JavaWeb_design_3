package dao;



import model.Warehouse;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IWarehoueDao {
    //增
    public boolean saveWarehouse(Connection con, Warehouse warehouse) throws SQLException;

    //删
    public int deleteWarehouse(Connection con, String wno) throws SQLException;

    //改
    public int updateWarehouse(Connection con, String wno,Warehouse warehouse) throws SQLException;

    //查
    public Warehouse findByWno(Connection con, String wno) throws SQLException;
    public List<Warehouse> findWarehouse(Connection con,Warehouse query) throws SQLException;

    public List<Warehouse> findAllWarehouse(Connection con) throws SQLException;

}
