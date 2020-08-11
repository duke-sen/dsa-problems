package general;

import java.util.HashMap;
import java.util.Map;

/**
 * Source : https://github.com/bephrem1/backtobackswe/blob/master/Linked%20Lists/LRUCache/LRUCache.java
 */

public class LRUCacheSolution {

    private class ListNode {
        private int key;
        private int value;

        private ListNode prev;
        private ListNode next;
    }

    private class LRUCache {
        private Map<Integer, ListNode> hashTable = new HashMap<>();
        private ListNode head;
        private ListNode tail;
        private int totalItemsInCache;
        private int maxCapacity;

        public LRUCache(int maxCapacity) {
            // Cache starts empty and capacity is set by client
            this.totalItemsInCache = 0;
            this.maxCapacity = maxCapacity;

            // Dummy head and tail nodes to avoid empty states
            head = new ListNode();
            tail = new ListNode();

            //Wire the head and tail together
            head.next = tail;
            tail.prev = head;
        }

        public Integer get(int key) {
            ListNode node = hashTable.get(key);

            if (node == null) return null;

            //Item has been accessed, move to the front of the cache
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            ListNode node = hashTable.get(key);

            if (node == null) {
                // Item not found, create a new key
                ListNode newNode = new ListNode();
                newNode.key = key;
                newNode.value = value;

                // Add to the hashtable and the actual list that represents the cache
                hashTable.put(key, newNode);
                addToFront(newNode);
                totalItemsInCache++;

                // If over capacity, remove the LRU item
                if (totalItemsInCache > maxCapacity)
                    removeLRUEntry();
            }
            else {
                // If item is found in the cache, just update it and move it to the head of the list
                node.value = value;
                moveToHead(node);
            }
        }

        private void removeLRUEntry() {
            ListNode tail = popTail();
            hashTable.remove(tail.key);
            --totalItemsInCache;
        }

        private ListNode popTail() {
            ListNode tailItem = tail.prev;
            removeFromList(tailItem);
            return tailItem;
        }

        private void addToFront(ListNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeFromList(ListNode node) {
            ListNode savedPrevious = node.prev;
            ListNode savedNext = node.next;

            savedPrevious.next = savedNext;
            savedNext.prev = savedPrevious;
        }

        private void moveToHead(ListNode node) {
            removeFromList(node);
            addToFront(node);
        }
    }
}
