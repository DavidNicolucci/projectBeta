package com.project3.cliente.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.cliente.dto.CustomerDto;
import com.project3.cliente.entity.Customer;
import com.project3.cliente.mapper.MapperCustomer;
import com.project3.cliente.repository.CustomerRepository;
import com.project3.cliente.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	CustomerRepository userRepo;

	@Autowired
	MapperCustomer mapperCustomer;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public String aggiungiCustomer(CustomerDto customerDto) throws Exception, IllegalArgumentException {
		
		log.info("Strat AggiungiUser");
		Customer entityUser = new Customer();
		String id;
		try {

			entityUser = mapperCustomer.dtoToEntity(customerDto);
			Customer ret = userRepo.save(entityUser);
			 id =  String.valueOf(ret.getIdCustomer()) ;
		
			
		} catch (IllegalArgumentException e) {
			
			log.error("errore nel mapper " + e.getMessage());
			throw new IllegalArgumentException();
		} catch (Exception ex) {
			
			log.error("errore nella query " + ex.getMessage());
			throw new Exception();
		}

		return id;

	}

	
}
