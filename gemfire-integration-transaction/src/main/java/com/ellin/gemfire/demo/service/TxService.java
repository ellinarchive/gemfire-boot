package com.ellin.gemfire.demo.service;

import com.ellin.gemfire.demo.model.Customer;
import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.EntryEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jeff on 9/23/2014.
 */
@Component()
public class TxService {

    @Autowired
    Cache cache;

    @Transactional
    public void doInTransaction(Customer c){


        cache.getRegion("CustomerCopy1").put(c.getId(),c);
        cache.getRegion("CustomerCopy2").put(c.getId(), c);

    }


}
