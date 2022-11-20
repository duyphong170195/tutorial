package leetcode.algorithms;

import java.math.BigInteger;
import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        ListNode listNode14 = new ListNode(3);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;

        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(4);
        ListNode listNode23 = new ListNode(6);
        ListNode listNode24 = new ListNode(8);
        ListNode listNode25 = new ListNode(9);
        ListNode listNode26 = new ListNode(7);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        listNode24.next = listNode25;
        listNode25.next = listNode26;


        Solution1.printValueOfListNode(Solution1.addTwoNumbers2(listNode11, listNode21));
    }
}


class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution1 {
    public static void convertListNumberToString(ListNode listNode, StringBuilder builder) {
        if(listNode == null) {
            return;
        }
        convertListNumberToString(listNode.next, builder);

        builder.append(listNode.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // convert each linked list string with non-reverse order
        // convert them to Integer
        StringBuilder builder1 = new StringBuilder();
        convertListNumberToString(l1, builder1);
        StringBuilder builder2 = new StringBuilder();
        convertListNumberToString(l2, builder2);
        // sum of it
        BigInteger sum = new BigInteger(builder1.toString()).add(new BigInteger(builder2.toString()));
        String sumString = String.valueOf(sum);
        // reverse it again
        ListNode result = new ListNode(sumString.charAt(sumString.length() -1) - '0');
        ListNode temp = result;
        for(int i = sumString.length() -2; i >=0; i--) {
            temp.next = new ListNode(sumString.charAt(i) - '0');
            temp = temp.next;
        }
        return result;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            int valOfL1 = 0;
            int valOfL2 = 0;
            if(l1 != null) {
                valOfL1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                valOfL2 = l2.val;
                l2 = l2.next;
            }
            sum = valOfL1 + valOfL2 + carry;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
        }
        return result.next;
    }

    public static void printValueOfListNode(ListNode result) {
        StringBuilder builder = new StringBuilder();
        ListNode cur = result;
        while (cur != null) {
            builder.append(cur.val);
            cur = cur.next;
        }
        System.out.println(builder.toString());
    }
}