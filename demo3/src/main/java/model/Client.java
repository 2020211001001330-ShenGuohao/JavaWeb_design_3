package model;

public class Client {
    private String cno;
    private String cname;
    private String ctel;

    public Client(String cno, String cname, String ctel) {
        this.cno = cno;
        this.cname = cname;
        this.ctel = ctel;
    }

    public Client() { }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cno='" + cno.trim()+ '\'' +
                ", cname='" + cname.trim() + '\'' +
                ", ctel='" + ctel.trim() + '\'' +
                '}';
    }
}
