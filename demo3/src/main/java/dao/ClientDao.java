package dao;

import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IClientDao{
    @Override
    public boolean saveClient(Connection con, Client client) throws SQLException {

        String sql="insert into client values(?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,client.getCno());
        st.setString(2,client.getCname());
        st.setString(3,client.getCtel());
        st.executeUpdate();

        return true;
    }

    @Override
    public int deleteClient(Connection con, String cno) throws SQLException {
        String sql="delete client where cno=?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,cno);
        st.executeUpdate();
         return 1;
    }

    @Override
    public int updateClient(Connection con, String cno, Client client) throws SQLException {

        String sql="update client set cno=?,cname=?,ctel=? where cno=?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,client.getCno());
        st.setString(2,client.getCname());
        st.setString(3,client.getCtel());
        st.setString(4,cno);

        st.executeUpdate();

        return 1;
    }

    @Override
    public Client findClientBycno(Connection con, String cno) throws SQLException {

        String sql="select * from client where cno=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,cno);

        ResultSet res = st.executeQuery();
        Client client=new Client();
        while (res.next()){
            client.setCno(res.getString("cno"));
            client.setCname(res.getString("cname"));
            client.setCtel(res.getString("ctel"));
        }
        return client;
    }

    @Override
    public List<Client> findClient(Connection con, Client query) throws SQLException {

        String sql="select * from client where 1=1";

        if(query.getCno().length()!=0){
            sql+=" and cno like ?";
        }
        if(query.getCname().length()!=0){
            sql+=" and cname like ?";
        }
        if(query.getCtel().length()!=0){
            sql+=" and ctel like ?";
        }

        int index=1;
        PreparedStatement st = con.prepareStatement(sql);
        if(query.getCno().length()!=0){
            st.setString(index++,"%"+query.getCno()+"%");
        }
        if(query.getCname().length()!=0){
            st.setString(index++,"%"+query.getCname()+"%");
        }
        if(query.getCtel().length()!=0){
            st.setString(index++,"%"+query.getCtel()+"%");
        }
        ResultSet res = st.executeQuery();
        List<Client> clients=new ArrayList<>();

        while (res.next()){
            Client client=new Client();
            client.setCno(res.getString("cno"));
            client.setCname(res.getString("cname"));
            client.setCtel(res.getString("ctel"));
            clients.add(client);
        }
        return clients;
    }

    @Override
    public List<Client> findAllClient(Connection con) throws SQLException {
        String sql = "select * from client";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet res = st.executeQuery();
        List<Client> clients = new ArrayList<>();

        while (res.next()) {
            Client client = new Client();
            client.setCno(res.getString("cno"));
            client.setCname(res.getString("cname"));
            client.setCtel(res.getString("ctel"));
            clients.add(client);
        }
        return clients;
      }
}
