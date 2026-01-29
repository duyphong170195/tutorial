package leetcode.twopointers;

import leetcode.algorithms.HeightOfTree;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode node1= new ListNode(1, null);
        ListNode node2= new ListNode(2, null);
        ListNode node3= new ListNode(3, null);
        ListNode node4= new ListNode(4, null);
        ListNode node5= new ListNode(5, null);
        ListNode node6= new ListNode(6, null);
        ListNode node7= new ListNode(7, null);
        ListNode node8= new ListNode(8, null);
        ListNode node9= new ListNode(9, null);
        ListNode node10= new ListNode(10, null);
        ListNode node11= new ListNode(11, null);
        ListNode node12= new ListNode(12, null);
        ListNode node13= new ListNode(13, null);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node7;

        ListNode listNode = detectCycleO1(node1);

        System.out.println();
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode tail = head;
        Set<ListNode> listNode = new HashSet<>();
        listNode.add(tail);
        while (tail.next != null) {
            tail = tail.next;
            if(listNode.contains(tail)) {
                return tail;
            }
            listNode.add(tail);
        }
        return null;
    }

    public static ListNode detectCycleO1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle using two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there's a cycle
            if (slow == fast) {
                break;
            }
        }

        // No cycle detected
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the starting node of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both pointers are at the start of the cycle
        return slow;
    }
}
