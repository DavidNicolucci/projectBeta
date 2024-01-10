package com.project3.cliente.mapper;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.project3.cliente.dto.CustomerDto;
import com.project3.cliente.entity.Customer;


@Component
public class MapperCustomer {

	
private final Logger log = LoggerFactory.getLogger(getClass());

	
	public Customer dtoToEntity(CustomerDto customerDto)throws Exception {
		
		log.info("Strat dtoToEntity");
		Customer customerEntity = new Customer();

		customerEntity.setCustomerName(Optional.ofNullable(customerDto.getCustomerName())
				.orElseThrow(()->  new IllegalArgumentException("nome cliente non valido")));
		
		customerEntity.setCustomerMail(Optional.ofNullable(customerDto.getCustomerMail())
				.orElseThrow(()-> new IllegalArgumentException("mail cliente non valido")));
		
		customerEntity.setCustomerTel(Optional.ofNullable(customerDto.getCustomerTel())
				.orElseThrow(()-> new IllegalArgumentException("telefono clinete non valida")));
		
	
		
//		List<User> userList = new ArrayList<User>();
//		userList.stream().forEach(user->{
//		});
		
		return customerEntity;

	}
	
}
