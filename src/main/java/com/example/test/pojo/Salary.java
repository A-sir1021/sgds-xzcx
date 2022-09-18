package com.example.test.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;
import com.example.Commen.Constant.Constant;

import java.io.Serializable;

@Component
@Data
public class Salary implements Serializable {

    static String serialVersionUID  = Constant.serialVersionUID ;


    private String salaId;
    /*
    * 基础薪资
    */
    private String salaBasemoney;
    /**
     * 备注事项
     */
    private String salaBz;
    /**
     * 月份
     */
    private String salaDate;
    /**
     * 其他福利
     */
    private String salaBenfit;

    /**
     * 实际所得
     */
    private String salaTakepay;


    @Override
    public String toString() {
        return "Salary{" +
                "salaId='" + salaId + '\'' +
                ", salaBasemoney='" + salaBasemoney + '\'' +
                ", salaBz='" + salaBz + '\'' +
                ", salaDate='" + salaDate + '\'' +
                ", salaBenfit='" + salaBenfit + '\'' +
                ", salaTakepay='" + salaTakepay + '\'' +
                '}';
    }

    public static String getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(String serialVersionUID) {
        Salary.serialVersionUID = serialVersionUID;
    }

    public String getSalaId() {
        return salaId;
    }

    public void setSalaId(String salaId) {
        this.salaId = salaId;
    }

    public String getSalaBasemoney() {
        return salaBasemoney;
    }

    public void setSalaBasemoney(String salaBasemoney) {
        this.salaBasemoney = salaBasemoney;
    }

    public String getSalaBz() {
        return salaBz;
    }

    public void setSalaBz(String salaBz) {
        this.salaBz = salaBz;
    }

    public String getSalaDate() {
        return salaDate;
    }

    public void setSalaDate(String salaDate) {
        this.salaDate = salaDate;
    }

    public String getSalaBenfit() {
        return salaBenfit;
    }

    public void setSalaBenfit(String salaBenfit) {
        this.salaBenfit = salaBenfit;
    }

    public String getSalaTakepay() {
        return salaTakepay;
    }

    public void setSalaTakepay(String salaTakepay) {
        this.salaTakepay = salaTakepay;
    }
}
