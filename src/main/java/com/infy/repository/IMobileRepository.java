package com.infy.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.infy.dto.MobileDTO;
import com.infy.entity.Mobile;
//public interface IMobileRepository extends CrudRepository<Mobile, Integer> {
	public interface IMobileRepository extends PagingAndSortingRepository<Mobile, Integer>{
	

	public List<Mobile> findByPurchasingDateAfter(LocalDate purchasingDate,Pageable pageable);

	
}
