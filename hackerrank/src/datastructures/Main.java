package datastructures;

public class Main {

    public static void main(String[] args) {

        Nodee node2111 = new Nodee(8, null, null);
        Nodee node2112 = new Nodee(9, null, null);

        Nodee node211 = new Nodee(4, node2111, node2112);
        Nodee node212 = new Nodee(5, null, null);
        Nodee node221 = new Nodee(6, null, null);
        Nodee node222 = new Nodee(7, null, null);
        Nodee node21 = new Nodee(2, node211, node212);
        Nodee node22 = new Nodee(3, node221, node222);

        Nodee root = new Nodee(1, node21, node22);

        int[] queries = new int[]{2};

        for(int i = 0; i< queries.length; i++) {
            root.printTreeInOrderTraversal(root, queries[i], 1);
            System.out.println();
        }

    }
}
