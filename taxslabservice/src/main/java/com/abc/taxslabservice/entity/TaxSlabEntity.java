package com.abc.taxslabservice.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tax_slab")
public class TaxSlabEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="slab_id")
	private int slabId;
	@Column(name="annual_income")
	private double annualIncome;
	@Column(name="slab_percentage")
	private double slabPercentage;
	public int getSlabId() 
	{
		return slabId;
	}
	public void setSlabId(int slabId) {
		this.slabId = slabId;
	}
	public double getAnnualIncome() 
	{
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) 
	{
		this.annualIncome = annualIncome;
	}
	public double getSlabPercentage() {
		return slabPercentage;
	}
	public void setSlabPercentage(double slabPercentage)
	{
		this.slabPercentage = slabPercentage;
	}	 
}