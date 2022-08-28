package dao;



import model.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IClientDao {

    public boolean saveClient(Connection con, Client client) throws SQLException;
    public int deleteClient(Connection con, String cno) throws SQLException;
    public int updateClient(Connection con, String cno,Client client) throws SQLException;


    public Client findClientBycno(Connection con, String cno) throws SQLException;

    public List<Client> findClient(Connection con,Client query) throws SQLException;
    public List<Client> findAllClient(Connection con) throws SQLException;
}
