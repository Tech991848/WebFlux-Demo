package com.dilip_tech.webfluxdemo.service;

import com.dilip_tech.webfluxdemo.dao.CustomerDao;
import com.dilip_tech.webfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired private CustomerDao dao;
    public List<Customer> loadAllCustomer(){
        long startTime=System.currentTimeMillis();
        System.out.println(startTime);
        List<Customer> customers=dao.getCustomers();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime);
        return customers;
    }

    public Flux<Customer> loadAllCustomerStream(){
        long startTime=System.currentTimeMillis();
        System.out.println(startTime);
        Flux<Customer> customers=dao.getCustomersStream();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime);
        return customers;
    }
}
