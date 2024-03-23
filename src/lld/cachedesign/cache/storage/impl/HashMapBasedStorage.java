package lld.cachedesign.cache.storage.impl;

import lld.cachedesign.cache.storage.Storage;
import lld.cachedesign.exception.NotFoundException;
import lld.cachedesign.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull())
            throw new StorageFullException("Capacity is full..");
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (!storage.containsKey(key))
            throw new NotFoundException(key + " does not exist, cannot remove");
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (!storage.containsKey(key))
            throw new NotFoundException(key + " does not exist in the cache");
        return storage.get(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
}
