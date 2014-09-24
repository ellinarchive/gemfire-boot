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
package com.ellin.gemfire.demo.model;

import java.io.Serializable;
import org.springframework.util.Assert;



public class Customer implements Serializable {


    private static final long serialVersionUID = -3860687524824507124L;

    private String firstname, lastname;

    private Long id;

    public Customer(){
        super();
    }

    /**
     * Creates a new {@link com.ellin.gemfire.demo.model.Customer} from the given parameters.
     * @param id the unique id;
     * @param firstname must not be {@literal null} or empty.
     * @param lastname must not be {@literal null} or empty.
     */
    public Customer(Long id,  String firstname, String lastname) {
        Assert.hasText(firstname);
        Assert.hasText(lastname);

        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }



    /**
     * Returns the firstname of the {@link com.ellin.gemfire.demo.model.Customer}.
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstname of the {@link com.ellin.gemfire.demo.model.Customer}.
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the lastname of the {@link com.ellin.gemfire.demo.model.Customer}.
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname of the {@link com.ellin.gemfire.demo.model.Customer}.
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    /**
     * Gets the id of the {@link com.ellin.gemfire.demo.model.Customer}.
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the {@link com.ellin.gemfire.demo.model.Customer}.
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "emailAddress=" + "emailAddress" +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", addresses=" + "addresses" +
                '}';
    }
}
