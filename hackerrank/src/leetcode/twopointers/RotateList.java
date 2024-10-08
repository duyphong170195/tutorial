package leetcode.twopointers;

public class RotateList {

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(4);
        ListNode listNode15 = new ListNode(5);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;

        ListNode head = rotateRight3(listNode11, 7);
        System.out.println();
    }
    private static ListNode first = null;
    private static int a = 0;
    public static ListNode rotateRight(ListNode head, int k) {
        first = head;
        recursion(head, k);
        return first;
    }

    public static void recursion(ListNode head, int k) {
        if(head.next != null) {
            recursion(head.next, k);
        }
        if(a < k) {
            head.next = first;
            first = head;
        }
        a++;
        if(a - 1 == k) {
            head.next = null;
        }
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        ListNode headTemp = head;
        ListNode lastTemp = null;
        ListNode current = null;
        while(headTemp.next != null) {
            lastTemp = headTemp.next;
            headTemp = headTemp.next;
        }

        for(int i = k; i > 0; i--) {
            lastTemp.next = head;
        }


        return first;
    }

    public static ListNode rotateRight3(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Calculate the length of the list
        ListNode curr = head;
        int length = 1;  // start with 1 because we are already at head
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: Connect tail to head, making the list circular
        curr.next = head;

        // Step 3: Find the new tail: length - (k % length) - 1th node
        // and the new head: length - (k % length)th node
        k = k % length;  // If k is greater than length, we rotate only the remainder
        int newTailPos = length - k;
        ListNode newTail = head;
        for (int i = 0; i < newTailPos; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // Step 4: Break the circular connection
        newTail.next = null;

        return newHead;
    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}