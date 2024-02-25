package com.example.restapidemo.service;

import com.example.restapidemo.model.Customer;
import com.example.restapidemo.model.CustomerFileName;

import java.util.List;
import java.util.Set;

public interface FileService {

    String createCSV (Customer customer);

    String createUniqueFileName();

    Customer readFile(String fileName);

     List<String> getAllFileNames();


}
