package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into user_login values(?,?)";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2, user.getPassword());
        st.executeUpdate();

        return true;
    }

    @Override
    public int deleteUser(Connection con, String username) throws SQLException {
        String sql="delete user_login where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.executeUpdate();
        return 1;
    }

    @Override
    public int updateUser(Connection con, String username, User user) throws SQLException {
        String sql = "update user_login set username=?,password=? where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,username);
        st.executeUpdate();

        return 1;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from user_login where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));

        }

        return user;
    }

    @Override
    public User findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from user_login where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));

        }

        return user;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User>users=new ArrayList<>();
        String sql="select * from user_login where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            users.add(user);
        }

        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User>users=new ArrayList<>();
        String sql="select * from user_login";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            users.add(user);
        }

        return users;
    }

    @Override
    public List<User> findUser(Connection con, User query) throws SQLException {
        String sql="select * from user_login where 1=1";
//        System.out.println(query);

        if(query.getUsername().length()!=0){
            sql+=" and username LIKE ?";
        }
        if(query.getPassword().length()!=0){
            sql+=" and password LIKE ?";
        }

//        System.out.println(sql);

        List<User> users=new ArrayList<User>();
        PreparedStatement st=con.prepareStatement(sql);

        int index=1;

        if(query.getUsername().length()!=0){
            st.setString(index++,"%"+query.getUsername()+"%");
        }
        if(query.getPassword().length()!=0){
            st.setString(index++,"%"+query.getPassword()+"%");
        }


        ResultSet res=st.executeQuery();

        while (res.next()){
            User user=new User();
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            users.add(user);
        }

        return  users;

    }
}
