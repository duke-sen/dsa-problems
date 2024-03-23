package lld.cachedesign.algorithms;

public class DoublyLinkedListNode<E> {
    public E element;
    public DoublyLinkedListNode<E> prev;
    public DoublyLinkedListNode<E> next;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
