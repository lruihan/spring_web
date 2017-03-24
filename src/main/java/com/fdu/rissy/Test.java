package com.fdu.rissy;

import com.fdu.rissy.pojo.User;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.codec.binary.Base64;


/**
 * Created by lins13 on 3/21/17.
 */
public class Test {
    public static void main(String[] args){

//        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache("preConfigured",
//                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
//                        ResourcePoolsBuilder.newResourcePoolsBuilder()
//                                .heap(10, EntryUnit.ENTRIES)
//                                .offheap(10, MemoryUnit.MB)))
//                .build();
//        PersistentCacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
//                .with(CacheManagerBuilder.persistence("/Users/lins13/Documents/ehcache/myData"))
//                .withCache("threeTieredCache",
//                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
//                                ResourcePoolsBuilder.newResourcePoolsBuilder()
//                                        .heap(10, EntryUnit.ENTRIES)
//                                        .offheap(1, MemoryUnit.MB)
//                                        .disk(20, MemoryUnit.MB)
//                        )
//                ).build(true);
//        Test test = new Test();
//        final URL myUrl = test.getClass().getClassLoader().getResource("ehcache.xml");
//        Configuration xmlConfig = new XmlConfigration
//        Configuration xmlConfig = new XmlConfiguration(myUrl);
//        CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
//
//        Cache<Long, String> preConfigured = cacheManager.getCache("preConfigured", Long.class, String.class);
//
//        Cache<Long, String> myCache = cacheManager.createCache("myCache",
//                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10).build()));
//
//        myCache.put(1L, "da one!");
//        String value = myCache.get(1L);
//       // System.out.println(value);
//
//
//        cacheManager.close();
//        CacheManager cacheMgr = CacheManager.newInstance();
//
//        //Initialise a cache if it does not already exist
//        if (cacheMgr.getCache("MyCache") == null) {
//            cacheMgr.addCache("MyCache");
//        }
//
//        //use it
//        Cache cache = cacheMgr.getCache("MyCache");
//
//        //Store an element
//        cache.put(new Element("key", new User("Rissy", 15)));
//        cache.put(new Element("key2", new User("Rissy2", 16)));
//        for(int i = 3; i < 100; i++){
//            cache.put(new Element("key" + i, new User("Rissy" + i, i)));
//        }
//
//        //Retrieve an element
//        Element el = cache.get("key5");
//        User myObj = (User)el.getObjectValue();
//        System.out.println(myObj.getName() + ", " + myObj.getAge());

        String credentials = "user:password";
        String base64ClientCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
        //Basic dXNlcjpwYXNzd29yZA==
        System.out.println("Basic " + base64ClientCredentials);


    }
}
