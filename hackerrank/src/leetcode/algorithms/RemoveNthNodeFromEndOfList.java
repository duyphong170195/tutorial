package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // go to the end of the list
        List<ListNode> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head);
            head = head.next;
        }
        if(vals.size() == 1) {
            return null;
        }  else {
            if( n==1) {
                ListNode listNode = vals.get(vals.size() - n -1);
                listNode.next = null;
                return vals.get(0);
            }
            else if( n== vals.size()) {
                return vals.get(1);
            } else {
                ListNode listNode = vals.get(vals.size() - n -1);
                listNode.next = vals.get(vals.size()-n+1);
                return vals.get(0);
            }
        }
    }
    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/2572916/Java-Solution-or-100-faster-or-99-less-memory-or-Explained
    int count = 0;
    int reverse = 0;
    public RemoveListNode removeNthFromEnd2(RemoveListNode head, int n) {
        // go to the end of the list
        if(head == null) {
            return null;
        }
        // move forward
        count++;
        removeNthFromEnd2(head.next, n);

        // move backward
        reverse++;
        if(reverse == n+1) {
            head.next = head.next.next;
            reverse = reverse - count;
            return head;
        }
        // trường hợp xóa nút đầu
        if (reverse == count)
            return head.next;
        // dùng để trả về nút đầu tiên vì sau khi đệ quy xong nó sẽ trả về head ở ngoài cùng
        return head;
        // n=5
        // 1,2,3,4,5
        // reserve = 0
        // count = 5
        // xoa nut 1
        // n =1
        // 1

    }

    public static void main(String[] args) {
        RemoveListNode removeListNode5 = new RemoveListNode(5);
        RemoveListNode removeListNode4 = new RemoveListNode(4, removeListNode5);
        RemoveListNode removeListNode3 = new RemoveListNode(3, removeListNode4);
        RemoveListNode removeListNode2 = new RemoveListNode(2, removeListNode3);
        RemoveListNode removeListNode1 = new RemoveListNode(1, removeListNode2);

        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        RemoveListNode head = removeNthNodeFromEndOfList.removeNthFromEnd2(removeListNode1, 3);
        System.out.println(head);

    }
}



class RemoveListNode {
    int val;
    RemoveListNode next;
    RemoveListNode() {}
    RemoveListNode(int val) { this.val = val; }
    RemoveListNode(int val, RemoveListNode next) { this.val = val; this.next = next; }
}
