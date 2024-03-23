package lld.cachedesign.algorithms;

import lld.cachedesign.exception.InvalidElementException;

public class DoublyLinkedList<E> {
    DoublyLinkedListNode<E> dummyhead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList() {
        dummyhead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);
        dummyhead.next = dummyTail;
        dummyTail.prev = dummyhead;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode<E> lastNode = dummyTail.prev;

        lastNode.next = node;
        node.prev = lastNode;

        node.next = dummyTail;
        dummyTail.prev = node;
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element) {
        if (element == null)
            throw new InvalidElementException("Passed in element cannot be null");
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public DoublyLinkedListNode<E> getFirstNode() {
        if (!isEmpty())
            return null;
        return dummyhead.next;
    }

    public DoublyLinkedListNode<E> getLastNode() {
        if (!isEmpty())
            return null;
        return dummyTail.prev;
    }
    public boolean isEmpty() {
        return dummyhead.next != dummyTail;
    }
}
