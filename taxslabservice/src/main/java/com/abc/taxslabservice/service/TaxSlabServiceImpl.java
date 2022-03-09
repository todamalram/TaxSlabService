package com.abc.taxslabservice.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.taxslabservice.Exceptions.TaxSlabNotFoundException;
import com.abc.taxslabservice.entity.TaxSlabEntity;
import com.abc.taxslabservice.model.TaxSlab;
import com.abc.taxslabservice.repository.TaxSlabRepository;
import com.abc.taxslabservice.util.EntityModelUtil;

 
@Service
public class TaxSlabServiceImpl implements TaxSlabService
{
	@Autowired
	private TaxSlabRepository taxSlabRepository;

	@Autowired
	private EntityModelUtil entityModelUtil;
	 
	@Override
	public  TaxSlab addTaxSlab(TaxSlab taxSlab) 
	{
			TaxSlabEntity addTaxSlab=taxSlabRepository.save(entityModelUtil.taxSlabModelToEntity(taxSlab));		
			TaxSlab newTaxSlab= entityModelUtil.taxSlabEntityToModel(addTaxSlab);
			return newTaxSlab;
	}

	@Override
	public List<TaxSlab> getAllTaxSlab() 
	{	 
		List<TaxSlabEntity> entityList= taxSlabRepository.findAll();
		List<TaxSlab> newList=entityModelUtil.taxSlabEntityToModelList(entityList);
		if(newList.isEmpty())
		{
			throw new TaxSlabNotFoundException("TaxSlab List Not Found");
		}
		return newList;
	}

	@Override
	public TaxSlab updateTaxSlab(TaxSlab taxSlab) {
		Optional<TaxSlabEntity> optionalTaxSlab=taxSlabRepository.findById(taxSlab.getSlabId());
		if(optionalTaxSlab.isEmpty())
		{
			throw new TaxSlabNotFoundException("TaxSlab Not Found with id:-"+taxSlab.getSlabId());
		}
		TaxSlabEntity updatedTaxSlab=taxSlabRepository.save(entityModelUtil.taxSlabModelToEntity(taxSlab));
		return entityModelUtil.taxSlabEntityToModel(updatedTaxSlab);
	}
}
