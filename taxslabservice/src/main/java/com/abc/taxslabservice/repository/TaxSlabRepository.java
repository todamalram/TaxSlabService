package com.abc.taxslabservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.abc.taxslabservice.entity.TaxSlabEntity;

@Repository
public interface TaxSlabRepository extends JpaRepository<TaxSlabEntity,Integer>
{

}
