package dsa;

import commons.ListNode;

public class ReverseNodesInKGroup {

    public ListNode reverseNodesInKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        int totalNode = getCountOfNodes(head);

        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;
        ListNode groupStart = head;


        for (int i = 0; i < totalNode/k; i++) {
            ListNode groupEnd = getKthNodeFromLinkedList(groupStart, k);

            ListNode reversedGroup = reverseKElements(groupStart, k);

            itr.next = reversedGroup;
            while (reversedGroup != null) {
                reversedGroup = reversedGroup.next;
                itr = itr.next;
            }
            groupStart = groupEnd;
        }
        itr.next = groupStart;

        return dummy.next;

    }
    public ListNode reverseKElements(ListNode head, int count) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while (current != null && count != 0) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count--;
        }
        return previous;
    }

    public ListNode getKthNodeFromLinkedList(ListNode head, int count) {
        ListNode temp = head;
        while (temp != null && count != 0) {
            temp = temp.next;
            count--;
        }
        return temp;
    }

    public Integer getCountOfNodes(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static void main(String[] args) {
        ListNode ele = new ListNode(1);
        ele.next = new ListNode(2);
        ele.next.next = new ListNode(3);
        ele.next.next.next = new ListNode(4);
        ele.next.next.next.next = new ListNode(5);
        //ele.next.next.next.next.next = new ListNode(6);
        //ele.next.next.next.next.next.next = new ListNode(7);
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode temp = reverseNodesInKGroup.reverseNodesInKGroup(ele, 3);
        System.out.println("Done");
    }
}
