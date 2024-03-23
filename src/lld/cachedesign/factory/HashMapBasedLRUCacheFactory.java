package lld.cachedesign.factory;

import lld.cachedesign.cache.Cache;
import lld.cachedesign.cache.policy.impl.LRUEvictionPolicy;
import lld.cachedesign.cache.storage.impl.HashMapBasedStorage;

public class HashMapBasedLRUCacheFactory<Key, Value> {

    public Cache<Key, Value> buildCache(final int capacity) {
        return new Cache<>(new LRUEvictionPolicy<>(),
                new HashMapBasedStorage<>(capacity));
    }
}
