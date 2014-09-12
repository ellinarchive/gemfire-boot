/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ellin.gf8.demo.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;
import org.springframework.util.Assert;


/**
 * A customer.
 *
 * @author Oliver Gierke
 * @author David Turanski
 */

@Region
public class Customer {


    private static final long serialVersionUID = -3860687524824507124L;

    private EmailAddress emailAddress;
    private String firstname, lastname;
    private Set<Address> addresses = new HashSet<Address>();

    @Id
    private Long id;

    /**
     * Creates a new {@link com.ellin.gf8.demo.model.Customer} from the given parameters.
     * @param id the unique id;
     * @param emailAddress must not be {@literal null} or empty.
     * @param firstname must not be {@literal null} or empty.
     * @param lastname must not be {@literal null} or empty.
     */
    public Customer(Long id, EmailAddress emailAddress, String firstname, String lastname) {
        Assert.hasText(firstname);
        Assert.hasText(lastname);
        Assert.notNull(emailAddress);

        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.id = id;
    }

    protected Customer() {
    }

    /**
     * Adds the given {@link Address} to the {@link com.ellin.gf8.demo.model.Customer}.
     *
     * @param address must not be {@literal null}.
     */
    public void add(Address address) {

        Assert.notNull(address);
        this.addresses.add(address);
    }

    /**
     * Returns the firstname of the {@link com.ellin.gf8.demo.model.Customer}.
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstname of the {@link com.ellin.gf8.demo.model.Customer}.
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the lastname of the {@link com.ellin.gf8.demo.model.Customer}.
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname of the {@link com.ellin.gf8.demo.model.Customer}.
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns the {@link EmailAddress} of the {@link com.ellin.gf8.demo.model.Customer}.
     *
     * @return
     */
    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the emailAddress of the {@link com.ellin.gf8.demo.model.Customer}.
     *
     * @param emailAddress
     */
    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the id of the {@link com.ellin.gf8.demo.model.Customer}.
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the {@link com.ellin.gf8.demo.model.Customer}.
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Return the {@link com.ellin.gf8.demo.model.Customer}'s addresses.
     *
     * @return
     */
    public Set<Address> getAddresses() {
        return Collections.unmodifiableSet(addresses);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "emailAddress=" + emailAddress +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
