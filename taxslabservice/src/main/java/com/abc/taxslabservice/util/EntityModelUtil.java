package com.abc.taxslabservice.util;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.abc.taxslabservice.entity.TaxSlabEntity;
import com.abc.taxslabservice.model.TaxSlab;
 
@Component
public class EntityModelUtil 
{
	public TaxSlabEntity taxSlabModelToEntity(TaxSlab taxSlab)
	{
		TaxSlabEntity taxSlabEntity=new TaxSlabEntity();
		taxSlabEntity.setSlabId(taxSlab.getSlabId());
		taxSlabEntity.setAnnualIncome(taxSlab.getAnnualIncome());
		taxSlabEntity.setSlabPercentage(taxSlab.getSlabPercentage());
		return taxSlabEntity;
	}
	public TaxSlab taxSlabEntityToModel(TaxSlabEntity taxSlabEntity)
	{
		TaxSlab taxSlab=new TaxSlab();
		taxSlab.setSlabId(taxSlabEntity.getSlabId());
		taxSlab.setAnnualIncome(taxSlabEntity.getAnnualIncome());
		taxSlab.setSlabPercentage(taxSlabEntity.getSlabPercentage());
		return taxSlab;
	}
	public List<TaxSlab> taxSlabEntityToModelList(List<TaxSlabEntity> entityList)
	{
		 List<TaxSlab> newList=new ArrayList<>();
		 entityList.forEach(entity ->
		 {
			TaxSlab taxSlab=new TaxSlab();
			taxSlab.setSlabId(entity.getSlabId());
			taxSlab.setAnnualIncome(entity.getAnnualIncome());
			taxSlab.setSlabPercentage(entity.getSlabPercentage());
			newList.add(taxSlab);
		 });
		 return newList;
	}
}
