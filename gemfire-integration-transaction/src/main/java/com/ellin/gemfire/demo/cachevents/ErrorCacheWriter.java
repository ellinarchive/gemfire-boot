package com.ellin.gemfire.demo.cachevents;


import com.gemstone.gemfire.cache.*;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

import java.util.Properties;

public class ErrorCacheWriter<K,V> implements CacheWriter,Declarable {

    public void beforeCreate(EntryEvent e) {
        System.out.println(e.getRegion().getFullPath()+"    Received beforeCreate event for entry: " +
                e.getKey() + ", " + e.getNewValue());
        throw new CacheWriterException("ugly error");
    }

    public void beforeUpdate(EntryEvent e) {
        System.out.println(e.getRegion().getFullPath()+"    Received beforeUpdate event for entry: " +
                e.getKey() + ", " + e.getNewValue());
    }

    public void beforeDestroy(EntryEvent e) {
        System.out.println(e.getRegion().getFullPath()+"    Received beforeDestroy event for entry: " +
                e.getKey());
    }

    @Override
    public void beforeRegionDestroy(RegionEvent regionEvent) throws CacheWriterException {

    }

    @Override
    public void beforeRegionClear(RegionEvent regionEvent) throws CacheWriterException {

    }

    public void beforeInvalidate(EntryEvent e) {
        System.out.println(e.getRegion().getFullPath()+"    Received beforeInvalidate event for entry: " +
                e.getKey());
    }

    public void beforeRegionLive(RegionEvent e) {
        System.out.println(e.getRegion().getFullPath()+"    Received beforeRegionLive event, sent to durable clients after \nthe server has finished replaying stored events.  ");
    }

    public void init(Properties props) {
        // do nothing
    }

    @Override
    public void close() {

    }
}