package dao;

import model.Drag;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IDragDao {

    //增
    public boolean saveDrag(Connection con, Drag drag) throws SQLException;

    //删
    public int deleteDrag(Connection con, String Dno) throws SQLException;

    //改
    public int updateDrag(Connection con, String Dno, Drag drag) throws SQLException;

    //查询
    public List<Drag> findDrag(Connection con,Drag query) throws SQLException;
    public Drag findByDno(Connection con,String Dno) throws SQLException;
    public List<Drag> findAllDrag(Connection con) throws SQLException;

}
