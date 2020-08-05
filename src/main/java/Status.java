public class Status {
    String burn = "BRN";
    String freeze = "FRZ";
    String paralyze = "PAR";
    String poison = "PSN";
    String badPoison = "BPN";
    String sloop = "SLP";
    String status;

    Status() {
        this.status = "Normal";
    }

    void setBurn() {
        this.status = burn;
    }

    void setFreeze() {
        this.status = freeze;
    }

    void setParalyze() {
        this.status = paralyze;
    }

    void setPoison() {
        this.status = poison;
    }

    void setBadPoison() {
        this.status = badPoison;
    }

    void setSleep() {
        this.status = sloop;
    }

    String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "burn='" + burn + '\'' +
                ", freeze='" + freeze + '\'' +
                ", paralyze='" + paralyze + '\'' +
                ", poison='" + poison + '\'' +
                ", badPoison='" + badPoison + '\'' +
                ", sloop='" + sloop + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
