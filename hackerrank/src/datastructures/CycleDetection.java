package datastructures;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection {

    static boolean hasCycle(SinglyLinkedListNode head) {
        if(head == null) {
            return false;
        }

        Set<Integer> addressObjectSet = new HashSet<>();

        while (head.next != null) {
            if(addressObjectSet.contains(Integer.valueOf(System.identityHashCode(head.next))) == false) {
                addressObjectSet.add(Integer.valueOf(System.identityHashCode(head.next)));
            } else {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}
