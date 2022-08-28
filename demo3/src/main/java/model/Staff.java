package model;

public class Staff {
    private String sno;
    private String sname;
    private String ssex;
    private String sage;
    private String sedu;
    private String wno;

    public Staff() {}
    public Staff(String sno, String sname, String ssex, String sage, String sedu, String wno) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.sedu = sedu;
        this.wno = wno;
    }



    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSedu() {
        return sedu;
    }

    public void setSedu(String sedu) {
        this.sedu = sedu;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "sno='" + sno.trim() + '\'' +
                ", sname='" + sname.trim() + '\'' +
                ", ssex='" + ssex.trim() + '\'' +
                ", sage='" + sage.trim() + '\'' +
                ", sedu='" + sedu.trim() + '\'' +
                ", wno='" + wno.trim() + '\'' +
                '}';
    }
}
