package com.ellin.gf8.demo.repository;


import com.ellin.gf8.demo.model.Customer;
import com.ellin.gf8.demo.model.EmailAddress;
import org.springframework.data.gemfire.repository.GemfireRepository;
import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: jellin
 * Date: 8/23/14
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerRepository extends GemfireRepository<Customer,Long> {

    /**
     * Returns all {@link Customer}s.
     *
     * @return
     */
    List<Customer> findAll();

    /**
     * Finds all {@link Customer}s with the given lastname.
     *
     * @param lastname
     * @return
     */
    List<Customer> findByLastname(String lastname);

    /**
     * Finds the Customer with the given {@link EmailAddress}.
     *
     * @param emailAddress
     * @return
     */
    @Query("SELECT * FROM /Customer x where x.emailAddress = $1")
    Customer findByEmailAddress(EmailAddress emailAddress);



}