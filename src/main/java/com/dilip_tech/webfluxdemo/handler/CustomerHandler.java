package com.dilip_tech.webfluxdemo.handler;

import com.dilip_tech.webfluxdemo.dao.CustomerDao;
import com.dilip_tech.webfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service public class CustomerHandler {
    @Autowired private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomers(ServerRequest request){
        Flux<Customer> customerList=customerDao.getCustomerList();
        return ServerResponse.ok().body(customerList,Customer.class);
    }


    public Mono<ServerResponse> findCustomer(ServerRequest request){
        int customerId=Integer.valueOf(request.pathVariable("input"));
        //Flux<Customer> customer=customerDao.getCustomerList().filter(c->c.getId()==customerId).take(1).single();
        Mono<Customer> customerMono=customerDao.getCustomerList().filter(c->c.getId()==customerId).next();
        return ServerResponse.ok().body(customerMono,Customer.class);
    }


    public Mono<ServerResponse> saveCustomer(ServerRequest request){
        Mono<Customer> custoemerMono=request.bodyToMono(Customer.class);

        Mono<String> saveRespose=custoemerMono.map(dto->dto.getId()+":"+dto.getName());
        return ServerResponse.ok().body(saveRespose,String.class);
    }

}
