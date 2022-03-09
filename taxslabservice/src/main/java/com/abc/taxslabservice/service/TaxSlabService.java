package com.abc.taxslabservice.service;

import java.util.List;

import com.abc.taxslabservice.model.TaxSlab;




public interface TaxSlabService
{
	public  TaxSlab addTaxSlab(TaxSlab taxSlab);
	public List< TaxSlab> getAllTaxSlab();
	public  TaxSlab updateTaxSlab(TaxSlab taxSlab);
	 

}
