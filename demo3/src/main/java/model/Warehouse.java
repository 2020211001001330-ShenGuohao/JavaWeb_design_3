package model;

public class Warehouse {
    private  String wno;
    private  String  wname;

    public Warehouse() { }

    public Warehouse(String wno, String wname) {
        this.wno = wno;
        this.wname = wname;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "wno='" + wno.trim() + '\'' +
                ", wname='" + wname.trim() + '\'' +
                '}';
    }
}
