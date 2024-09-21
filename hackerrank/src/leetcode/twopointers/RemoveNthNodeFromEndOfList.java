package leetcode.twopointers;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        removeNthFromEnd(head.next, n);
k
        n--;
        if(n == 0 ) {

        }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n, int start) {
        if (head == null) return  null;

        removeNthFromEnd(head.next, n, start + 1);


        return head != null ? head : null;
    }


}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}