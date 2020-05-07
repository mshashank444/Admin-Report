package com.capgemini.go.dto;

public class ViewDetailedSalesReportByProductDTO {
	
	private int period;
	private Double revenue;
	private Double amountChange;
	private Double percentageGrowth;
	private String code;
	private String type;
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	public Double getAmountChange() {
		return amountChange;
	}
	public void setAmountChange(Double amountChange) {
		this.amountChange = amountChange;
	}
	public Double getPercentageGrowth() {
		return percentageGrowth;
	}
	public void setPercentageGrowth(Double percentageGrowth) {
		this.percentageGrowth = percentageGrowth;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	

}