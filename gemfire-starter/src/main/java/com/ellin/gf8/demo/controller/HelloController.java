package com.ellin.gf8.demo.controller;

import com.ellin.gf8.demo.model.Customer;
import com.ellin.gf8.demo.model.EmailAddress;
import com.ellin.gf8.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: jellin
 * Date: 9/10/14
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class HelloController {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    CustomerRepository customerRepository = null;

    public void doSomeStuff(){

        System.out.println("Creating new Customer");
        Customer customer = new Customer(1L,new EmailAddress("customer@customer.com"),"1","Last");
        Customer customer2 = new Customer(2L,new EmailAddress("customer2@customer.com"),"2","Last");
        Customer customer3 = new Customer(3L,new EmailAddress("customer3@customer.com"),"3","Last");

        customerRepository.save(customer);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        List <Customer> customers = customerRepository.findAll();

        System.out.println("Found a few Customers, How Many = " + customers.size());


        Customer customers2 = customerRepository.findByEmailAddress(new EmailAddress("customer@customer.com"));




    }

}
