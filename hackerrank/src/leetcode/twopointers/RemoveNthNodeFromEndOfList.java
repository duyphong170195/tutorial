package leetcode.twopointers;


public class RemoveNthNodeFromEndOfList {

    private static int a = 0;

    public static void main(String[] args) {
        ListNode removeListNode5 = new ListNode(5);
        ListNode removeListNode4 = new ListNode(4, removeListNode5);
        ListNode removeListNode3 = new ListNode(3, removeListNode4);
        ListNode removeListNode2 = new ListNode(2, removeListNode3);
        ListNode removeListNode1 = new ListNode(1, removeListNode2);

        ListNode head = removeNthFromEnd(removeListNode1, 3);
        System.out.println(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null && n == 1) {
            return null;
        }
        if(head.next != null) {
            removeNthFromEnd(head.next, n);
            a++;
        }
        if (a == n) {
            head.next = head.next.next;
        }

       return head;
    }


}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}