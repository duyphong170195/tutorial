package leetcode.twopointers;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
//        ListNode listNode11 = new ListNode(1);
//        ListNode listNode12 = new ListNode(1);
//        ListNode listNode13 = new ListNode(2);
//        ListNode listNode14 = new ListNode(2);
//        ListNode listNode15 = new ListNode(3);
//        ListNode listNode16 = new ListNode(3);
//        ListNode listNode17 = new ListNode(4);
//        listNode11.next = listNode12;
//        listNode12.next = listNode13;
//        listNode13.next = listNode14;
//        listNode14.next = listNode15;
//        listNode15.next = listNode16;
//        listNode16.next = listNode17;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(1);
        ListNode listNode13 = new ListNode(2);
        ListNode listNode14 = new ListNode(2);
        ListNode listNode15 = new ListNode(3);
        ListNode listNode16 = new ListNode(3);
        ListNode listNode17 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        listNode15.next = listNode16;
        listNode16.next = listNode17;

        ListNode head = deleteDuplicates2(listNode11);
        System.out.println();
    }

//    public static ListNode deleteDuplicates(ListNode head) {
//        ListNode currentNode = head;
//        ListNode actualHead = null;
//        int count = 0;
//
//        while(currentNode.next != null) {
//            ListNode iterialNode = currentNode;
//            while (iterialNode.val == iterialNode.next.val) {
//                iterialNode = iterialNode.next;
//            }
//
//            if(currentNode.val == iterialNode.val ) {
//                if(count == 0) {
//                    actualHead = currentNode;
//                }
//                currentNode = iterialNode.next;
//                iterialNode.next = null;
//            } else {
//                currentNode.next = iterialNode.next ;
//            }
//            count ++;
////            if(newHead.val == newHead.next.val) {
////                ListNode current = newHead;
////                while (current.val == current.next.val) {
////                    current = current.next;
////                }
////                if(current.next != null) {
////                    newHead = current.next;
////                    if(rememberNode != null) {
////                        rememberNode.next = newHead;
////                    } else {
////                        rememberNode = newHead;
////                        current.next = null;
////                    }
////                } else {
////                    newHead = null;
////                }
////            } else  {
////                rememberNode = newHead;
////                newHead = newHead.next;
////            }
//        }
//        return actualHead;
//    }


    public static ListNode deleteDuplicates2(ListNode head) {
        // Create a dummy node that points to the head of the list
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy; // previous node pointer

        while (head != null) {
            // If we're at a duplicate value node (check if next node has the same value)
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with this value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Now, head points to the last duplicate node, so skip it
                prev.next = head.next;
            } else {
                // Otherwise, move the previous pointer
                prev = prev.next;
            }
            // Move head pointer forward
            head = head.next;
        }

        return dummy.next;
    }
}
