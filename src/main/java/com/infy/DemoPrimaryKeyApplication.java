package com.infy;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;

import com.infy.dto.MobileDTO;
import com.infy.service.MobileServiceImpl;

@SpringBootApplication
public class DemoPrimaryKeyApplication implements CommandLineRunner {
	
	public static final Log LOGGER = LogFactory.getLog(DemoPrimaryKeyApplication.class);
	
	@Autowired
	MobileServiceImpl service;
	
	@Autowired
	Environment env; 

		public static void main(String[] args) {
			SpringApplication.run(DemoPrimaryKeyApplication.class,args);
		}
		
		public void run(String... args) throws Exception {
			//addCustomer();
			getAllMobile();
			getAllMobileByPurchasingDateAfter();
			getAllMobileSort();
		}
		
		
		

		/*public void addCustomer() {
			MobileDTO mobileDTO = new MobileDTO();
			mobileDTO.setModelname("Hawaii");
			mobileDTO.setPurchasingDate(LocalDate.now());
			try {
				Integer id = service.addMobile(mobileDTO);
				LOGGER.info(env.getProperty("UserInterface.INSERT_SUCCESS") + id);
			} catch (Exception e) {
			
				if (e.getMessage() != null)
					LOGGER.info(env.getProperty(e.getMessage(),"Something went wrong. Please check log file for more details."));
			}*/
		
		private void getAllMobileSort() {
			Sort sort= Sort.by("purchaseDate");
			List<MobileDTO>mobileDTO=service.getAllMobileSort(sort);
			mobileDTO.forEach(LOGGER::info);
			
		}

		private void getAllMobileByPurchasingDateAfter() {
			LocalDate purchaseDate = LocalDate.of(2018, 8, 10);
			List<MobileDTO>mobile=
					service.getAllByPurchasingDateAfter(purchaseDate, 0,5);
			mobile.forEach(LOGGER::info);
		}
		
		private void getAllMobile() {
			List<MobileDTO>mobileList=service.getAllMobile(0,5);
			mobileList.forEach(LOGGER::info);
			
		}
		
		}
		
	
	
	


