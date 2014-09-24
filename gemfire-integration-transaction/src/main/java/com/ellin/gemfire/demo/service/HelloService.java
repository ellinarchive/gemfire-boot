package com.ellin.gemfire.demo.service;

import com.ellin.gemfire.demo.model.Customer;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
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
public class HelloService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

   // @Autowired
    //CustomerRepository customerRepository = null;

    public void doSomeStuff() throws InterruptedException {

        System.out.println("Creating new Customer");
        Customer customer = new Customer(1L,"1","Last");
        Customer customer2 = new Customer(2L,"2","Last");
        Customer customer3 = new Customer(3L,"3","Last");
        //Customer customer2 = new Customer(2L,new EmailAddress("customer2@customer.com"),"2","Last");
        //Customer customer3 = new Customer(3L,new EmailAddress("customer3@customer.com"),"3","Last");

        //customerRepository.save(customer);
        //customerRepository.save(customer2);
        //customerRepository.save(customer3);

        //List <Customer> customers = customerRepository.findAll();

        //System.out.println("Found a few Customers, How Many = " + customers.size());


       // Customer customers2 = customerRepository.findByEmailAddress(new EmailAddress("customer@customer.com"));

        Region r = CacheFactory.getAnyInstance().getRegion("Customer");

        r.put("1",customer);
        r.put("2",customer2);
        r.put("3",customer3);
        System.out.println("customer size is "+r.keySet());



        Thread.sleep(1000);
        Region product = CacheFactory.getAnyInstance().getRegion("CustomerCopy1");

        System.out.println("product size is "+product.keySet());

        Region order = CacheFactory.getAnyInstance().getRegion("CustomerCopy2");

        Region error = CacheFactory.getAnyInstance().getRegion("Error");


        System.out.println("error size is "+error.keySet());

        System.out.println("order size is "+order.keySet());

    }

}
