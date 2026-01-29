package leetcode.twopointers;

import java.util.List;

public class ReorderList {

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // get the middle of linked list
        while (fast.next != null) {

            if(fast.next.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // get half above
        ListNode secondHalf = slow.next;


        // reverse half

        ListNode reversedLinkedList = reverseList(secondHalf);

        slow.next = null;
        ListNode firstHalf = head;
        ListNode secondHalfReversed = reversedLinkedList;
        while(secondHalfReversed != null) {

            ListNode temp0 = firstHalf;
            ListNode temp1 = secondHalfReversed;
            // go to next node
            firstHalf = firstHalf.next;
            ListNode temp3 = firstHalf;
            secondHalfReversed = secondHalfReversed.next;

            // reorder
            temp0.next = temp1;
            temp1.next = temp3;
        }
    }

    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while (temp2.next != null) {
            ListNode temp3 = temp2;
            ListNode temp4 = temp2;
            temp2 = temp2.next;
            temp3.next = temp1;
            temp1 = temp4;
        }

        temp2.next = temp1;
        head.next = null;
        return temp2;
    }

    public static void main(String[] args) {
        ListNode node1= new ListNode(1, null);
        ListNode node2= new ListNode(2, null);
        ListNode node3= new ListNode(3, null);
        ListNode node4= new ListNode(4, null);
        ListNode node5= new ListNode(5, null);
        ListNode node6= new ListNode(6, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        reorderList(node1);
        System.out.println();
    }
}
