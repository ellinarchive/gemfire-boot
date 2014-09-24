package com.ellin.gemfire.demo.cachevents;


        import com.gemstone.gemfire.cache.Declarable;
        import com.gemstone.gemfire.cache.EntryEvent;
        import com.gemstone.gemfire.cache.RegionEvent;
        import com.gemstone.gemfire.cache.util.CacheListenerAdapter;
        import java.util.Properties;

public class CacheListener<K,V> extends CacheListenerAdapter<K,V> implements Declarable {

    public void afterCreate(EntryEvent<K,V> e) {
        System.out.println(e.getRegion().getFullPath()+"    Received afterCreate event for entry: " +
                e.getKey() + ", " + e.getNewValue());
    }

    public void afterUpdate(EntryEvent<K,V> e) {
        System.out.println(e.getRegion().getFullPath()+"    Received afterUpdate event for entry: " +
                e.getKey() + ", " + e.getNewValue());
    }

    public void afterDestroy(EntryEvent<K,V> e) {
        System.out.println(e.getRegion().getFullPath()+"    Received afterDestroy event for entry: " +
                e.getKey());
    }

    public void afterInvalidate(EntryEvent<K,V> e) {
        System.out.println(e.getRegion().getFullPath()+"    Received afterInvalidate event for entry: " +
                e.getKey());
    }

    public void afterRegionLive(RegionEvent e) {
        System.out.println(e.getRegion().getFullPath()+"    Received afterRegionLive event, sent to durable clients after \nthe server has finished replaying stored events.  ");
    }

    public void init(Properties props) {
        // do nothing
    }
}