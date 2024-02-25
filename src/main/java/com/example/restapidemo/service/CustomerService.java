package com.example.restapidemo.service;

import com.example.restapidemo.model.Customer;
import com.example.restapidemo.model.CustomerFileName;

import java.util.List;

public interface CustomerService {

    String create(Customer customer);

    Customer findCustomerByFileName(String fileName);

//    List<CustomerFileName> findAll();
//
//    Customer create(Customer customer);
//
//    CustomerFileName createCFN(CustomerFileName customer);
//
//    Customer getByFileName(String fileName);

}
