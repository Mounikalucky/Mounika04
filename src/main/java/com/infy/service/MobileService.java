package com.infy.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.infy.dto.MobileDTO;

public interface MobileService {
	public Integer addMobile(MobileDTO mobileDTO);
	public List<MobileDTO> getAllMobile(Integer pageNo, Integer pageSize);
	public List<MobileDTO> getAllByPurchasingDateAfter(LocalDate purchasingDate, Integer pageNo, Integer pageSize );
	public List<MobileDTO> getAllMobileSort(Sort sort);;

}
