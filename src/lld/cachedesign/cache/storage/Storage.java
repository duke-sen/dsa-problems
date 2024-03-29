package lld.cachedesign.cache.storage;

import lld.cachedesign.exception.NotFoundException;
import lld.cachedesign.exception.StorageFullException;

public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws StorageFullException;
    void remove(Key key) throws NotFoundException;
    Value get(Key key) throws NotFoundException;
}
