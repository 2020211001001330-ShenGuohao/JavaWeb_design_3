package model;

public class Client_cal_buy {

    public String cname;
    public String buy_sum;

    public Client_cal_buy() {
    }

    public Client_cal_buy(String cname, String buy_sum) {
        this.cname = cname;
        this.buy_sum = buy_sum;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBuy_sum() {
        return buy_sum;
    }

    public void setBuy_sum(String buy_sum) {
        this.buy_sum = buy_sum;
    }

    @Override
    public String toString() {
        return "Client_cal_buy{" +
                "cname='" + cname + '\'' +
                ", buy_sum=" + buy_sum +
                '}';
    }
}
