package leetcode.twopointers;

import java.util.Arrays;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        ListNode node1= new ListNode(-1, null);
        ListNode node2= new ListNode(5, null);
        ListNode node3= new ListNode(3, null);
        ListNode node4= new ListNode(4, null);
        ListNode node5= new ListNode(0, null);
        ListNode node6= new ListNode(2, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode head = sortList(node1);
        System.out.println(head);
    }

    public static ListNode sortList(ListNode head) {
        ListNode tempHead = head;

        ListNode actualHead = null;

        while (tempHead.next != null) {
            ListNode tempStart = tempHead;
            if(tempHead.val > tempHead.next.val) {
                while (tempHead.val > tempHead.next.val) {
                    tempHead = tempHead.next;
                }

                ListNode tempEndNext = tempHead.next;

                ListNode tempEnd = tempHead;
                tempEnd.next = null;
                List<ListNode> headPartition = reverseList(tempStart);
                headPartition.get(1).next = tempEndNext;
                actualHead = headPartition.get(0);
                tempHead = head;
            } else {
                tempHead = tempHead.next;
            }
        }
        return actualHead;
    }

    public static List<ListNode> reverseList(ListNode head) {

        if(head == null || head.next == null) return List.of(head);

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
        return List.of(temp2, head);
    }
}
