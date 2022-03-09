package com.abc.taxslabservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.taxslabservice.model.TaxSlab;
import com.abc.taxslabservice.service.TaxSlabService;
 

@RestController
@RequestMapping("/taxslab")
public class TaxSlabController 
{
	@Autowired
	private TaxSlabService  taxSlabService;
	
	@PostMapping("/add")
	public TaxSlab addTaxSlab(@RequestBody TaxSlab taxSlab)
	{
		TaxSlab newTaxSlab=taxSlabService.addTaxSlab(taxSlab);
		return newTaxSlab;
	}
	@GetMapping("/slablist")
	public List<TaxSlab> viewTaxSlabs()
	{
		List<TaxSlab> list=taxSlabService.getAllTaxSlab();
		return list;
	}
	@PutMapping("/update")
	public TaxSlab updatetaxSlab(@RequestBody TaxSlab taxSlab)
	{
		TaxSlab updatedTaxSlab=taxSlabService.updateTaxSlab(taxSlab);
		return updatedTaxSlab;
	}
}
