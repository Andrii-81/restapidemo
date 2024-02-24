package com.example.restapidemo.service.impl;

import com.example.restapidemo.model.Customer;
import com.example.restapidemo.model.CustomerFileName;
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
        String uniqueFileName = fileService.createCSV(customer);
        return uniqueFileName;
    }

    @Override
    public Customer findCustomerByFileName(String fileName) {
        Customer customer = fileService.readFile(fileName);
        return customer;
    }


}
