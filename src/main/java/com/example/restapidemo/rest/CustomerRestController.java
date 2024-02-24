package com.example.restapidemo.rest;

import com.example.restapidemo.model.Customer;
import com.example.restapidemo.service.CustomerService;
import com.example.restapidemo.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    final private CustomerService customerService;
    final private FileService fileService;

    public CustomerRestController(CustomerService customerService, FileService fileService) {
        this.customerService = customerService;
        this.fileService = fileService;
    }

    @GetMapping("/v1")
    public String getLoginPage() {
        return "Hello World!";
    }


    //@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    // public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
    @PostMapping()
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
        if(customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String fileName = this.customerService.create(customer);
        //return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
        return new ResponseEntity<String>(fileName, HttpStatus.CREATED);
    }



    @RequestMapping(value = "{uniqueFileName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("uniqueFileName") String uniqueName) {
        if(uniqueName == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = this.customerService.findCustomerByFileName(uniqueName);
        if(customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);

    }



}
