package dao;


import model.Staff;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IStaffDao {

    //增
    public boolean saveStaff(Connection con, Staff staff) throws SQLException;

    //删
    public int deleteStaff(Connection con, String sno) throws SQLException;

    //改
    public int updateStaff(Connection con, String sno,Staff staff) throws SQLException;


    //查
    public Staff findStaffBySno(Connection con, String sno) throws SQLException;
    public List<Staff> findStaff(Connection con,Staff query) throws SQLException;
    public List<Staff> findAllStaff(Connection con) throws SQLException;

}
