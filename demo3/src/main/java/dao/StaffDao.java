package dao;

import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDao implements IStaffDao{
    @Override
    public List<Staff> findAllStaff(Connection con) throws SQLException {
        String sql="select * from staff";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet res = st.executeQuery();
        List<Staff> staffs=new ArrayList<>();
        while (res.next()){
            Staff staff=new Staff();
            staff.setSno(res.getString("sno"));
            staff.setSname(res.getString("sname"));
            staff.setSsex(res.getString("Ssex"));
            staff.setSage(res.getString("Sage"));
            staff.setSedu(res.getString("Sedu"));
            staff.setWno(res.getString("wno"));
            staffs.add(staff);
        }

        return staffs;
    }


    @Override
    public boolean saveStaff(Connection con, Staff staff) throws SQLException {
          String sql="insert into staff values(?,?,?,?,?,?)";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,staff.getSno());
        st.setString(2,staff.getSname());
        st.setString(3,staff.getSsex());
        st.setString(4,staff.getSage());
        st.setString(5,staff.getSedu());
        st.setString(6,staff.getWno());
        st.executeUpdate();

        return true;
    }

    @Override
    public int deleteStaff(Connection con, String sno) throws SQLException {

        String sql="delete staff where sno=?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,sno);
        st.executeUpdate();

        return 1;
    }

    @Override
    public int updateStaff(Connection con, String sno, Staff staff) throws SQLException {

        String sql="update staff set sno=?,sname=?,ssex=?,sage=?,sedu=?,wno=? where sno=?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,staff.getSno());
        st.setString(2,staff.getSname());
        st.setString(3,staff.getSsex());
        st.setString(4,staff.getSage());
        st.setString(5,staff.getSedu());
        st.setString(6,staff.getWno());
        st.setString(7,sno);
        st.executeUpdate();
        return 1;
    }

    @Override
    public Staff findStaffBySno(Connection con, String sno) throws SQLException {

        String sql="select * from staff where sno=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,sno);

        ResultSet res = st.executeQuery();
        Staff staff=new Staff();
        while (res.next()){
            staff.setSno(res.getString("sno"));
            staff.setSname(res.getString("sname"));
            staff.setSsex(res.getString("Ssex"));
            staff.setSage(res.getString("Sage"));
            staff.setSedu(res.getString("Sedu"));
            staff.setWno(res.getString("wno"));
        }
        return staff;

    }

    @Override
    public List<Staff> findStaff(Connection con, Staff query) throws SQLException {

        String sql="select * from staff where 1=1";

        if(query.getSno().length()!=0){
            sql+=" and sno like ?";
        }
        if(query.getSname().length()!=0){
            sql+=" and sname like ?";
        }
        if(query.getSsex().length()!=0){
            sql+=" and ssex like ?";
        }
        if(query.getSage().length()!=0){
            sql+=" and sage like ?";
        }
        if(query.getSedu().length()!=0){
            sql+=" and sedu like ?";
        }
        if(query.getWno().length()!=0){
            sql+=" and wno like ?";
        }

        int index=1;
        PreparedStatement st = con.prepareStatement(sql);
        if(query.getSno().length()!=0){
            st.setString(index++,"%"+query.getSno()+"%");
        }
        if(query.getSname().length()!=0){
            st.setString(index++,"%"+query.getSname()+"%");
        }
        if(query.getSsex().length()!=0){
            st.setString(index++,"%"+query.getSsex()+"%");
        }
        if(query.getSage().length()!=0){
            st.setString(index++,"%"+query.getSage()+"%");
        }
        if(query.getSedu().length()!=0){
            st.setString(index++,"%"+query.getSedu()+"%");
        }
        if(query.getWno().length()!=0){
            st.setString(index++,"%"+query.getWno()+"%");
        }

        ResultSet res = st.executeQuery();
        List<Staff> staffs=new ArrayList<>();
        while (res.next()){
            Staff staff=new Staff();
            staff.setSno(res.getString("sno"));
            staff.setSname(res.getString("sname"));
            staff.setSsex(res.getString("Ssex"));
            staff.setSage(res.getString("Sage"));
            staff.setSedu(res.getString("Sedu"));
            staff.setWno(res.getString("wno"));
            staffs.add(staff);
        }

        return staffs;
    }
}
