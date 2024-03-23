package lld.cachedesign;

import lld.cachedesign.cache.Cache;
import lld.cachedesign.factory.HashMapBasedLRUCacheFactory;

public class CacheTest {
    public static void main(String[] args) {
        Cache<Integer, String> cache
                = new HashMapBasedLRUCacheFactory<Integer, String>()
                .buildCache(3);

        cache.put(1, "Shruti");
        cache.put(2, "Duke");
        cache.get(1);
        cache.put(3, "Yogesh");
        cache.put(4, "Sahil");

        System.out.println(cache.get(2));

    }
}
