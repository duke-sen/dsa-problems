package lld.cachedesign.cache;

import lld.cachedesign.cache.policy.EvictionPolicy;
import lld.cachedesign.cache.policy.impl.LRUEvictionPolicy;
import lld.cachedesign.cache.storage.Storage;
import lld.cachedesign.cache.storage.impl.HashMapBasedStorage;
import lld.cachedesign.exception.NotFoundException;
import lld.cachedesign.exception.StorageFullException;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException ex) {
            System.out.println("Storage is full, trying to evict element");
            Key keyToRemove = evictionPolicy.evictKey();
            this.storage.remove(keyToRemove);
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException ex) {
            System.out.println("Tried to access non existing key");
            return null;
        }
    }
}
