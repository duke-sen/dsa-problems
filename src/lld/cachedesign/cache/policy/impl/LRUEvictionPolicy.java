package lld.cachedesign.cache.policy.impl;

import lld.cachedesign.algorithms.DoublyLinkedList;
import lld.cachedesign.algorithms.DoublyLinkedListNode;
import lld.cachedesign.cache.policy.EvictionPolicy;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private final DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (mapper.containsKey(key)) {
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else {
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> firstNode = dll.getFirstNode();
        if (firstNode == null)
            return null;
        dll.detachNode(firstNode);
        return firstNode.element;

    }
}
