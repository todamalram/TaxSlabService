package com.abc.taxslabservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.taxslabservice.Exceptions.TaxSlabNotFoundException;
import com.abc.taxslabservice.entity.TaxSlabEntity;
import com.abc.taxslabservice.model.TaxSlab;
import com.abc.taxslabservice.repository.TaxSlabRepository;
import com.abc.taxslabservice.util.EntityModelUtil;
@SpringBootTest
public class TaxSlabServiceTest 
{
	@Mock
	private TaxSlabRepository taxSlabRepository;
	@InjectMocks
	private TaxSlabServiceImpl taxSlabService;
	
	@Mock
	private EntityModelUtil entityModelUtil;
	
	@Test 
	public  void testAddTaxSlab() 
	{
		TaxSlab taxSlab=new TaxSlab();
		taxSlab.setSlabId(1);
		taxSlab.setSlabPercentage(15);
		taxSlab.setAnnualIncome(1000000);
		
		TaxSlabEntity taxSlabEntity=entityModelUtil.taxSlabModelToEntity(taxSlab);
		when(taxSlabRepository.save(taxSlabEntity)).thenReturn(taxSlabEntity);
		TaxSlab newTaxSlab=taxSlabService.addTaxSlab(taxSlab);
		verify(taxSlabRepository,times(1)).save(taxSlabEntity);	 
	} 	
	@Test
	public void testUpdateTaxSlab()
	{ 
		TaxSlabEntity taxSlabEntity=new TaxSlabEntity();
		TaxSlab taxSlab=new TaxSlab();
		taxSlab.setSlabId(1);
		taxSlab.setSlabPercentage(15);
		taxSlab.setAnnualIncome(1000000);
		 
		Optional<TaxSlabEntity> optionalTaxSlabEntity=Optional.of(taxSlabEntity);
 
		when(taxSlabRepository.findById(1)).thenReturn(optionalTaxSlabEntity);
		TaxSlabEntity updatedTaxSlab=taxSlabRepository.save(taxSlabEntity);
		entityModelUtil.taxSlabEntityToModel(updatedTaxSlab);
		taxSlabService.updateTaxSlab(taxSlab);
		verify(taxSlabRepository,times(1)).save(entityModelUtil.taxSlabModelToEntity(taxSlab));
	}
	
	@Test
	void testGetTaxSlabNotFound() {

		TaxSlab taxSlab=new TaxSlab();
		taxSlab.setSlabId(1);
		taxSlab.setSlabPercentage(15);
		taxSlab.setAnnualIncome(1000000);

		int id=taxSlab.getSlabId();
		when(taxSlabRepository.findById(2)).thenThrow(TaxSlabNotFoundException.class);	
		assertThrows(TaxSlabNotFoundException.class, () -> taxSlabService.updateTaxSlab(taxSlab));
	}
	 
	
}
