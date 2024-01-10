package com.project3.cliente.service;

import com.project3.cliente.dto.CustomerDto;

public interface CustomerService {

	public String aggiungiCustomer(CustomerDto userDto) throws Exception, IllegalArgumentException;
}
