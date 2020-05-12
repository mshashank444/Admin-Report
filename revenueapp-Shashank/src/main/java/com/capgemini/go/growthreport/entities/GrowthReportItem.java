package com.capgemini.go.growthreport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="growth_report_table")
public class GrowthReportItem {

    @Id
    @GeneratedValue
    private int id;

    private String period;

    private double revenue;

    private double amountChange;

    private double percentageGrowth;

    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getAmountChange() {
        return amountChange;
    }


    public void setAmountChange(double amountChange) {
        this.amountChange = amountChange;
    }

    public double getPercentageGrowth() {
        return percentageGrowth;
    }

    public void setPercentageGrowth(double percentageGrowth) {
        this.percentageGrowth = percentageGrowth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
