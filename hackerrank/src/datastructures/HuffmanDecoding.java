package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HuffmanDecoding {

    // nut ben trai se la ky tu dau tien gap phai
    // 0 thi dich sang ben trai
    // 1 thi dich sang ben phai




//     void decode(String s, Nodee root) {
//        LinkedList<Integer> stringLinkedList = new LinkedList<>();
//        for(int i = 0; i< s.length(); i++) {
//            stringLinkedList.add(Integer.valueOf(s.charAt(i) + ""));
//        }
//
//         List<String> decodedString = new ArrayList<>();
//        while(stringLinkedList.size() != 0) {
//            deQuyCay(stringLinkedList, root, decodedString);
//        }
//
//         System.out.println(String.join("", decodedString));
//    }
//
//    static void deQuyCay(LinkedList<Integer> stringLinkedList, Nodee root, List<String> decodedString) {
//        if(stringLinkedList.size() == 0) {
//            return;
//        }
//
//        if(stringLinkedList.size() == 1 && root.frequency == 1) {
//            System.out.println(root.data);
//            return;
//        }
//
//        if(stringLinkedList.getFirst() == 1) {
//            stringLinkedList.pop();
//            char data = root.right.data;
//
//            if(data != '\0') {
//                decodedString.add(data + "");
//            } else {
//                deQuyCay(stringLinkedList, root.right, decodedString);
//            }
//        }else {
//            stringLinkedList.pop();
//            char data = root.left.data;
//            if(data != '\0') {
//                decodedString.add(data + "");
//            } else {
//                deQuyCay(stringLinkedList, root.left, decodedString);
//            }
//        }
//    }

    public static void main(String[] args) {
//        Node node1 = new Node(1, 'B', null, null);
//        Node node2 = new Node(1, 'C', null, null);
//        Node node3 = new Node(2, '1', node1, node2);
//        Node node4 = new Node(3, 'A', null, null);
//        Node node5 = new Node(5, '1', node3, node4);
//
//        String s = "1001011";
//
//        HuffmanDecoding huffmanDecoding = new HuffmanDecoding();
//        huffmanDecoding.decode(s, node5);

        char character = 'ϕ';
        int ascii = (int) character;
        System.out.println(ascii);

    }

}

//class Node {
//    public  int frequency; // the frequency of this tree
//    public  char data;
//    public Node left, right;
//
//    public Node(int frequency, char data, Node left, Node right) {
//        this.frequency = frequency;
//        this.data = data;
//        this.left = left;
//        this.right = right;
//    }
//}
