package model;

public class Stastic {
    private String wno;
    private String salesum;
    private String saleprice;
    private String serplus;

    public Stastic(){}
    public Stastic(String wno, String salesum, String saleprice, String serplus) {
        this.wno = wno;
        this.salesum = salesum;
        this.saleprice = saleprice;
        this.serplus = serplus;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    public String getSalesum() {
        return salesum;
    }

    public void setSalesum(String salesum) {
        this.salesum = salesum;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getSerplus() {
        return serplus;
    }

    public void setSerplus(String serplus) {
        this.serplus = serplus;
    }

    @Override
    public String toString() {
        return "Stastic{" +
                "wno='" + wno + '\'' +
                ", salesum='" + salesum + '\'' +
                ", saleprice='" + saleprice + '\'' +
                ", serplus='" + serplus + '\'' +
                '}';
    }
}
