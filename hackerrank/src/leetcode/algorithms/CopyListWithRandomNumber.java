package leetcode.algorithms;

import java.time.chrono.ThaiBuddhistEra;
import java.util.*;

public class CopyListWithRandomNumber {

    public static void main(String[] args) {
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        head.next = node1;
        node1.next = node2;
        node1.random = head;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;

//
//        head.next = node1;
//        head.random = null;
//
//
//        Node randomNode2 = new Node(5);
//        Node nextNode3 = new Node(6);
//        Node randomNode3 = new Node(7);
//        node1.next = node2;
//        node1.random = head;
//        node2.next = nextNode3;
//        node2.random = randomNode3;
//        randomNode2.next = nextNode3;

        Node copyRandomList = Solution.copyRandomList(head);
        System.out.println(copyRandomList);
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
   static Map<Node,Node> map = new HashMap<>();

    public static Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = new Node(head.val);
        map.put(head,temp);
        temp.next = copyRandomList(head.next);
        temp.random = map.get(head.random);
        return temp;
    }
//    public static Node copyRandomList(Node head) {
//
//        HashMap<Node, Integer> hashMapOfOriginalNodes = new HashMap<>();
//        List<Node> listRandomNodeByIndex = new ArrayList<>();
//        List<Node> listCopyNodeByIndex = new ArrayList<>();
//
//        int index = 0;
//        while(head != null) {
//            Node nextNodeClone = new Node(head.val);
//            hashMapOfOriginalNodes.put(head, index);
//            listRandomNodeByIndex.add(index, head.random);
//
//            listCopyNodeByIndex.add(index, nextNodeClone);
//            if(index > 0) {
//                listCopyNodeByIndex.get(index - 1).next = listCopyNodeByIndex.get(index);
//            }
//
//            index = index + 1;
//            head = head.next;
//        }
//
//       for( int i = 0; i < listRandomNodeByIndex.size(); i++) {
//           Node randomNode = listRandomNodeByIndex.get(i);
//           if(randomNode == null) {
//               listCopyNodeByIndex.get(i).random = null;
//           } else {
//               Integer indexa = hashMapOfOriginalNodes.get(randomNode);
//               listCopyNodeByIndex.get(i).random = listCopyNodeByIndex.get(indexa);
//           }
//
//       }
//        return listCopyNodeByIndex.get(0);
//    }


}


//     public static Node copyRandomList(Node head) {
// if(head == null) {
//     return null;
// }
//         HashMap<Node, Integer> hashMapOfOriginalNodes = new HashMap<>();
//         List<Node> listRandomNodeByIndex = new ArrayList<>();
//         hashMapOfOriginalNodes.put(head, 0);
//         listRandomNodeByIndex.add(0, head.random);

//         List<Node> listCopyNodeByIndex = new ArrayList<>();
//         listCopyNodeByIndex.add(0, new Node(head.val));

//         Node nextNode = null;
//         int index = 1;
//         while(head.next != null) {
//             Node nextNodeClone = new Node(head.next.val);
//             listCopyNodeByIndex.add(index, nextNodeClone);
//             listCopyNodeByIndex.get(index - 1).next = listCopyNodeByIndex.get(index);

//             hashMapOfOriginalNodes.put(head.next, index);
//             listRandomNodeByIndex.add(index, head.next.random);
//             index = index + 1;
//             head = head.next;
//         }

//        for( int i = 0; i < listRandomNodeByIndex.size(); i++) {
//            Node randomNode = listRandomNodeByIndex.get(i);
//            if(randomNode == null) {
//                listCopyNodeByIndex.get(i).random = null;
//            } else {
//                Integer indexa = hashMapOfOriginalNodes.get(randomNode);
//                listCopyNodeByIndex.get(i).random = listCopyNodeByIndex.get(indexa);
//            }

//        }
//         return listCopyNodeByIndex.get(0);
//     }