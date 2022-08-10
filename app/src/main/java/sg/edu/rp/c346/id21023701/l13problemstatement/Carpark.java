package sg.edu.rp.c346.id21023701.l13problemstatement;

public class Carpark {
private String TotalLots;
private String LotType;
private String LotAvail;
private String carparkNum;
//private String update_datetime;


    public Carpark(String totalLots, String lotType, String lotAvail, String carparknum) {
        TotalLots = totalLots;
        LotType = lotType;
        LotAvail = lotAvail;
        carparkNum = carparknum;
    }

    public String getTotalLots() {
        return TotalLots;
    }

    public void setTotalLots(String totalLots) {
        TotalLots = totalLots;
    }

    public String getLotType() {
        return LotType;
    }

    public void setLotType(String lotType) {
        LotType = lotType;
    }

    public String getLotAvail() {
        return LotAvail;
    }

    public void setLotAvail(String lotAvail) {
        LotAvail = lotAvail;
    }

    public String getCarparkNum() {
        return carparkNum;
    }

    public void setCarparkNum(String carparkNum) {
        this.carparkNum = carparkNum;
    }

    @Override
    public String toString() {
        return "Carpark{" +
                "TotalLots='" + TotalLots + '\'' +
                ", LotType='" + LotType + '\'' +
                ", LotAvail='" + LotAvail + '\'' +
                ", carparkNum='" + carparkNum + '\'' +
                '}';
    }
}
