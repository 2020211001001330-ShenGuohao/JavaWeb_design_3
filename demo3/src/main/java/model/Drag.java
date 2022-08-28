package model;

public class Drag {
    private String dno;
    private String dname;
    private String dsum;
    private String dprice;
    private String wno;

    public Drag() {}

    @Override
    public String toString() {
        return "Drag{" +
                "dno='" + dno.trim() + '\'' +
                ", dname='" + dname.trim() + '\'' +
                ", dsum='" + dsum.trim() + '\'' +
                ", dprice='" + dprice.trim() + '\'' +
                ", wno='" + wno.trim() + '\'' +
                '}';
    }

    public Drag(String dno, String dname, String dsum, String dprice, String wno) {
        this.dno = dno;
        this.dname = dname;
        this.dsum = dsum;
        this.dprice = dprice;
        this.wno = wno;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDsum() {
        return dsum;
    }

    public void setDsum(String dsum) {
        this.dsum = dsum;
    }

    public String getDprice() {
        return dprice;
    }

    public void setDprice(String dprice) {
        this.dprice = dprice;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }
}

