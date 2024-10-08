package leetcode.twopointers;

public class PartitionList {

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(0);
        ListNode listNode15 = new ListNode(2);
        ListNode listNode16 = new ListNode(5);
        ListNode listNode17 = new ListNode(2);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        listNode15.next = listNode16;
        listNode16.next = listNode17;

        ListNode result = partition(listNode11, 3);
        System.out.println();
    }


    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummyLessThanX = new ListNode(Integer.MIN_VALUE, null);
        ListNode dummyHeadLessThanX = dummyLessThanX;

        ListNode dummyGreaterThanX = new ListNode(Integer.MIN_VALUE, null);
        ListNode dummyHeadGreaterThanX = dummyGreaterThanX;
        while (head != null) {
            if(head.val < x) {
                dummyHeadLessThanX.next = head;
                dummyHeadLessThanX = dummyHeadLessThanX.next;
            } else {
                dummyHeadGreaterThanX.next = head;
                dummyHeadGreaterThanX = dummyHeadGreaterThanX.next;
            }
            head = head.next;
        }


        dummyHeadLessThanX.next = dummyGreaterThanX.next;
        dummyHeadGreaterThanX.next = null;
        return dummyLessThanX.next;
    }
}
