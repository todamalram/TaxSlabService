package com.abc.taxslabservice.model;

public class TaxSlab 
{
	private int slabId;
	private double annualIncome;
	private double slabPercentage;
	public int getSlabId() {
		return slabId;
	}
	public void setSlabId(int slabId) {
		this.slabId = slabId;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public double getSlabPercentage() {
		return slabPercentage;
	}
	public void setSlabPercentage(double slabPercentage) {
		this.slabPercentage = slabPercentage;
	}
}
