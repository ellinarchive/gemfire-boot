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
        Customer customer = new Customer(1L,"John","Doe");
        Customer customer2 = new Customer(2L,"John","Smith");
        Customer customer3 = new Customer(3L,"Paul","Revere");

        Region r = CacheFactory.getAnyInstance().getRegion("Customer");

        r.put(customer.getLastname(),customer);
        r.put(customer2.getLastname(),customer2);
        r.put(customer3.getLastname(),customer3);


        Thread.sleep(1000);

        Region product = CacheFactory.getAnyInstance().getRegion("CustomerCopy1");


        Region order = CacheFactory.getAnyInstance().getRegion("CustomerCopy2");

        Region error = CacheFactory.getAnyInstance().getRegion("Error");

        System.out.println("customer list is "+r.keySet());

        System.out.println("order list is "+order.keySet());
        System.out.println("product list is "+product.keySet());
        System.out.println("error list is "+error.keySet());


    }

}
