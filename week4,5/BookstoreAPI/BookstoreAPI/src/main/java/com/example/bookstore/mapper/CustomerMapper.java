package com.example.bookstore.mapper;
import com.example.bookstore.dto.CustomerDTO;
import com.example.bookstore.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public class CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer) {
		return null;
	}
    Customer customerDTOToCustomer(CustomerDTO customerDTO) {
		return null;
	}
}
