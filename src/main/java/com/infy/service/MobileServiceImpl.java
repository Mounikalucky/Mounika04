package com.infy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.infy.dto.MobileDTO;
import com.infy.entity.Mobile;
import com.infy.repository.IMobileRepository;
@Service
@Transactional

public class MobileServiceImpl implements MobileService {
	@Autowired
	private IMobileRepository respository;
	@Override
	public Integer addMobile(MobileDTO mobileDTO) {
		Mobile mobile=new Mobile();
		mobile.setPurchasingDate(mobileDTO.getPurchasingDate());
		mobile.setModelname(mobileDTO.getModelname());
		respository.save(mobile);
		return mobile.getMobileid();
	}
	@Override
	public List<MobileDTO> getAllMobile(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Mobile> page =  respository.findAll(pageable);
		List<Mobile> entityList = page.getContent();
		List<MobileDTO> mobile;
		mobile = entityList.stream().map(p -> new MobileDTO(p.getMobileid(), p.getModelname(), p.getPurchasingDate())).collect(Collectors.toList());
		return mobile;
	}
	
	@Override
	public List<MobileDTO> getAllByPurchasingDateAfter(LocalDate purchasingDate, Integer pageNo, Integer pageSize) {
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		List<Mobile> moble =  respository.findByPurchasingDateAfter(purchasingDate, pageable);
		List<MobileDTO>mobile;
		
		mobile=moble.stream().map(t -> new MobileDTO(t.getMobileid(),t.getModelname(),t.getPurchasingDate()) )
				.collect(Collectors.toList());
		return mobile;
	}
	
	
	@Override
	public List<MobileDTO> getAllMobileSort(Sort sort) {
		Iterable<Mobile> moble=respository.findAll(sort);
		List<MobileDTO> moblieDTO= new ArrayList<MobileDTO>();
		moble.forEach(t -> {
			MobileDTO m = new MobileDTO(t.getMobileid(),t.getModelname(),t.getPurchasingDate());
			moblieDTO.add(m);
		});
		
		return moblieDTO;
	}
	


	}
	



