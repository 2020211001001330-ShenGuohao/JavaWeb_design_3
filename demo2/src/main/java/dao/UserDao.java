package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao{
    public List<String> findAllusername(Connection con) throws SQLException{

        String sql="select username from usertable";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet res = st.executeQuery();
        List<String>usernames=new ArrayList<>();

        while (res.next()){
            usernames.add(res.getString("username"));
        }

        return usernames;
    }
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into usertable values(?,?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,user.getId());
        st.setString(2,user.getUsername());
        st.setString(3,user.getPassword());
        st.setString(4,user.getEmail());
        st.setString(5,user.getGender());
        st.setString(6,user.getBirthday());

        st.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection con, String id) throws SQLException {
        String sql="delete usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,id);
        st.executeUpdate();

        return 0;
    }

    @Override
    public int updateUser(Connection con, String before ,User user) throws SQLException {
        String sql = "update usertable set id=?,username=?,password=?,email=?,gender=?,birthday=? where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, user.getId().trim());
        st.setString(2, user.getUsername().trim());
        st.setString(3, user.getPassword().trim());
        st.setString(4, user.getEmail().trim());
        st.setString(5, user.getGender().trim());
        st.setString(6, user.getBirthday().trim());
        st.setString(7,before);

        st.executeUpdate();

        return 0;
    }

    @Override
    public User findById(Connection con, String id) throws SQLException {
        String sql="select * from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,id);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setId(res.getString("id"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setEmail(res.getString("email"));
            user.setGender(res.getString("gender"));
            user.setBirthday(res.getString("birthday"));
        }

        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);

        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setId(res.getString("id"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setEmail(res.getString("email"));
            user.setGender(res.getString("gender"));
            user.setBirthday(res.getString("birthday"));
        }

        return user;

    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User>users=new ArrayList<>();
        String sql="select * from usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setId(res.getString("id"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setEmail(res.getString("email"));
            user.setGender(res.getString("gender"));
            user.setBirthday(res.getString("birthday"));
            users.add(user);
        }

        return users;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User>users=new ArrayList<>();
        String sql="select * from usertable where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setId(res.getString("id"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setEmail(res.getString("email"));
            user.setGender(res.getString("gender"));
            user.setBirthday(res.getString("birthday"));
            users.add(user);
        }

        return users;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        List<User>users=new ArrayList<>();
        String sql="select * from usertable where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setId(res.getString("id"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setEmail(res.getString("email"));
            user.setGender(res.getString("gender"));
            user.setBirthday(res.getString("birthday"));
            users.add(user);
        }

        return users;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        List<User>users=new ArrayList<>();
        String sql="select * from usertable where gender=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setId(res.getString("id"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setEmail(res.getString("email"));
            user.setGender(res.getString("gender"));
            user.setBirthday(res.getString("birthday"));
            users.add(user);
        }

        return users;
    }

    @Override
    public List<User> findByBirthdate(Connection con, String birthDate) throws SQLException {
        List<User>users=new ArrayList<>();
        String sql="select * from usertable where birthday=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,birthDate);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setId(res.getString("id"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setEmail(res.getString("email"));
            user.setGender(res.getString("gender"));
            user.setBirthday(res.getString("birthday"));
            users.add(user);
        }

        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User>users=new ArrayList<>();
        String sql="select * from usertable";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet res=st.executeQuery();
        User user=null;

        while (res.next()){
            user=new User();
            user.setId(res.getString("id"));
            user.setUsername(res.getString("username"));
            user.setPassword(res.getString("password"));
            user.setEmail(res.getString("email"));
            user.setGender(res.getString("gender"));
            user.setBirthday(res.getString("birthday"));
            users.add(user);
        }

        return users;
    }
    public List<User> findUser(Connection con,User query) throws SQLException{
        String sql="select * from usertable where 1=1";
        System.out.println(query);
        if(query.getId().length()!=0 ){
            sql+=" and id=?";
        }
        if(query.getUsername().length()!=0){
            sql+=" and username LIKE ?";
        }
        if(query.getPassword().length()!=0){
            sql+=" and password LIKE ?";
        }
        if(query.getEmail().length()!=0){
            sql+="and email LIKE ?";
        }if(query.getGender().length()!=0){
            sql+="and gender LIKE ?";
        }if(query.getBirthday().length()!=0){
            sql+="and birthday LIKE ?";
        }
        System.out.println(sql);

        List<User> users=new ArrayList<User>();
        PreparedStatement st=con.prepareStatement(sql);

        int index=1;
        if(query.getId().length()!=0){
            st.setString(index++,query.getId());
        }
        if(query.getUsername().length()!=0){
            st.setString(index++,"%"+query.getUsername()+"%");
        }
        if(query.getPassword().length()!=0){
            st.setString(index++,"%"+query.getPassword()+"%");
        }
        if(query.getEmail().length()!=0){
            st.setString(index++,"%"+query.getEmail()+"%");
        }
        if(query.getGender().length()!=0){
            st.setString(index++,"%"+query.getGender()+"%");
        }
        if(query.getBirthday().length()!=0){
            st.setString(index++,"%"+query.getBirthday()+"%");
        }

        ResultSet res=st.executeQuery();

        while (res.next()){
           User user=new User();
           user.setId(res.getString("id"));
           user.setUsername(res.getString("username"));
           user.setPassword(res.getString("password"));
           user.setEmail(res.getString("email"));
           user.setGender(res.getString("gender"));
           user.setBirthday(res.getString("birthday"));

            users.add(user);
        }

        return  users;
    }
}
