package model;

public class Orderd {

    private String ono;
    private String dno;
    private String cno;
    private String osum;
    private String bdate;
    public Orderd(){}
    public Orderd(String ono, String dno, String cno, String osum, String bdate) {
        this.ono = ono;
        this.dno = dno;
        this.cno = cno;
        this.osum = osum;
        this.bdate = bdate;
    }

    public String getOno() {
        return ono;
    }

    public void setOno(String ono) {
        this.ono = ono;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getOsum() {
        return osum;
    }

    public void setOsum(String osum) {
        this.osum = osum;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    @Override
    public String toString() {
        return "Orderd{" +
                "ono='" + ono.trim() + '\'' +
                ", dno='" + dno.trim() + '\'' +
                ", cno='" + cno.trim() + '\'' +
                ", osum='" + osum.trim() + '\'' +
                ", bdate='" + bdate.trim() + '\'' +
                '}';
    }
}
