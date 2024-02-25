package com.example.restapidemo.service.impl;

import com.example.restapidemo.model.Customer;
import com.example.restapidemo.model.CustomerFileName;
import com.example.restapidemo.model.NotValidCustomer;
import com.example.restapidemo.service.CustomerService;
import com.example.restapidemo.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final FileService fileService; // ДЛЯ ЧТЕНИЯ-ЗАПИСИ В ФАЙЛ
    public CustomerServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }


    @Override
    public String create(Customer customer) {
        // CALL VALIDATION METHOD
        try {
            validationCustomer(customer);
        } catch (Exception e) {
           e.printStackTrace();
        }

        String uniqueFileName = fileService.createCSV(customer);
        return uniqueFileName;
    }
    @Override
    public Customer findCustomerByFileName(String fileName) {
        Customer customer = fileService.readFile(fileName);
        return customer;
    }

    // VALIDATION METHOD
    public void validationCustomer(Customer customer) throws NotValidCustomer {
        if((customer.getId() == 0) || (customer.getName() == null) || (customer.getAge() == 0) || (customer.getMobile_no() == null)) {
            throw new NotValidCustomer();
        }
        if(customer.getMobile_no().length() != 12) {
            throw new NotValidCustomer();
        }
        if(customer.getAge() < 0 || customer.getAge() > 110) {
            throw new NotValidCustomer();
        }
        //return customer;
    }

}
