package dao;

import model.Orderd;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IOrderdDao {

    public boolean saveOrderd(Connection con, Orderd orderd) throws SQLException;
    public int deleteOrderd(Connection con, String ono) throws SQLException;
    public int updateOrderd(Connection con, String ono,Orderd orderd) throws SQLException;

    public Orderd findOrderdByOno(Connection con, String ono) throws SQLException;

    public List<Orderd> findOrder(Connection con,Orderd query) throws SQLException;
    public List<Orderd> findAllOrder(Connection con) throws SQLException;
}
