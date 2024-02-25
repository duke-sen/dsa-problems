package dsa;

import commons.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Use 2 pointers, make ptrOne go 1 step and ptrTwo 2 step, without exceeding
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // firstHalf ends with slowPtr, and second half starts with secondHalf
        ListNode secondHalf = slowPtr.next;
        slowPtr.next = null;

        // reverse the second half
        ListNode reversedSecondHalf = reverseList(secondHalf);

        // Merge the two halves
        ListNode first = head;
        while (reversedSecondHalf != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = reversedSecondHalf.next;

            first.next = reversedSecondHalf;
            reversedSecondHalf.next = temp1;

            first = temp1;
            reversedSecondHalf = temp2;
        }

    }

    private ListNode reverseList(ListNode node) {
        ListNode current = node;
        ListNode prev = null;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        // l1.next.next.next.next = new ListNode(5);

        new ReorderList().reorderList(l1);
        System.out.println("Done");
    }
}
