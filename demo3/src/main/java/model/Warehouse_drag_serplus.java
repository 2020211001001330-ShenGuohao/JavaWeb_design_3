package model;

public class Warehouse_drag_serplus {
    String wno;
    String dname;
    String serplus;

    public Warehouse_drag_serplus() {
    }

    public Warehouse_drag_serplus(String wno, String dname, String serplus) {
        this.wno = wno;
        this.dname = dname;
        this.serplus = serplus;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getSerplus() {
        return serplus;
    }

    public void setSerplus(String serplus) {
        this.serplus = serplus;
    }

    @Override
    public String toString() {
        return "Warehouse_drag_serplus{" +
                "wno='" + wno + '\'' +
                ", dname='" + dname + '\'' +
                ", serplus='" + serplus + '\'' +
                '}';
    }
}
