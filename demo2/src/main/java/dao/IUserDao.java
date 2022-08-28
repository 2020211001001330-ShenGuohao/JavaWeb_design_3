package dao;


import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public boolean saveUser(Connection con, User user) throws SQLException;
    public int deleteUser(Connection con, String id) throws SQLException;
    public int updateUser(Connection con, String id,User user) throws SQLException;

    public User findById(Connection con, String id) throws SQLException;
    public User findByUsernamePassword(Connection con, String username,String password) throws SQLException;
    public List<User> findByUsername(Connection con, String username) throws SQLException;
    public List<User> findByPassword(Connection con, String password) throws SQLException;
    public List<User> findByEmail(Connection con,String email) throws SQLException;
    public List<User> findByGender(Connection con,String gender) throws SQLException;
    public List<User> findByBirthdate(Connection con, String birthDate) throws SQLException;
    public List<User> findAllUser(Connection con) throws SQLException;
    public List<User> findUser(Connection con,User query) throws SQLException;

    public List<String> findAllusername(Connection con) throws SQLException;

}
