package datastructures;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

//        Nodee node2111 = new Nodee(8, null, null);
//        Nodee node2112 = new Nodee(9, null, null);
//
//        Nodee node211 = new Nodee(4, node2111, node2112);
//        Nodee node212 = new Nodee(5, null, null);
//        Nodee node221 = new Nodee(6, null, null);
//        Nodee node222 = new Nodee(7, null, null);
//        Nodee node21 = new Nodee(2, node211, node212);
//        Nodee node22 = new Nodee(3, node221, node222);
//
//        Nodee root = new Nodee(1, node21, node22);
//
//        int[] queries = new int[]{2};
//
//        for(int i = 0; i< queries.length; i++) {
//            root.printTreeInOrderTraversal(root, queries[i], 1);
//            System.out.println();
//        }


        strongPassword("123456a@");

        int[][] arr = {{0, 1, 2, 3, 4},
                {4, 3, 2, 1, 0},
                {5, 6, 7, 8, 9}};
        int[] deleteRows = {2};
        int[] deleteColumns = {2, 5};
        deleteRowsColumns(arr, deleteRows, deleteColumns);
    }


    boolean strengthCompare(int tayTraiA, int tayPhaiA, int tayTraiB, int tayPhaiB) {
        if (((tayTraiA == tayTraiB) && (tayPhaiA == tayPhaiB))
                || ((tayTraiA == tayPhaiB) && (tayPhaiA == tayTraiB))) {
            return true;
        }
        return false;
    }

    static boolean strongPassword(String pwd) {
        if (pwd.length() < 8 || pwd.length() >= 30 || pwd.contains(" ")) {
            return false;
        }


        String regex1 = ".*[a-z]{1,}.*";
        String regex2 = ".*[0-9]{1,}.*";
        String regex3 = ".*[A-Z]{1,}.*";
        String regex4 = ".*[!@#$%ˆ&*()\\[\\]{},\\./<>?]{1,}.*";

        int count = 0;
        if (pwd.matches(regex1)) {
            count++;
        }
        if (pwd.matches(regex2)) {
            count++;
        }
        if (pwd.matches(regex3)) {
            count++;
        }
        if (pwd.matches(regex4)) {
            count++;
        }


        if (count >= 3) {
            return true;
        }
        return false;
    }

    static int[][] deleteRowsColumns(int[][] inputMatrix, int[] deleteRows, int[] deleteColumns) {
        int rowSize = inputMatrix.length;
        int columnSize = inputMatrix[0].length;

        Set<Integer> deleteRowsSet = new HashSet<>();
        for (int i = 0; i < deleteRows.length; i++) {
            deleteRowsSet.add(deleteRows[i] - 1);
        }
        Set<Integer> deleteColumnsSet = new HashSet<>();
        for (int i = 0; i < deleteColumns.length; i++) {
            deleteColumnsSet.add(deleteColumns[i] - 1);
        }


        int arrayDeletedRow[][] = new int[rowSize - deleteRows.length][columnSize];
        int r1 = 0, c1 = 0;

        for (int j = 0; j < inputMatrix.length; j++) {
            if (deleteRowsSet.contains(j))
                continue;
            for (int k = 0; k < inputMatrix[0].length; k++) {
                arrayDeletedRow[r1][c1] = inputMatrix[j][k];
                c1++;
            }
            r1++;
            c1 = 0;
        }
        int arrayDeletedColumn[][] = new int[arrayDeletedRow.length][columnSize - deleteColumns.length];
        int r2 = 0, c2 = 0;


        for (int j = 0; j < arrayDeletedRow[0].length; j++) {
            if (deleteColumnsSet.contains(j)) {
                continue;
            }
            for (int k = 0; k < arrayDeletedRow.length; k++) {
                System.out.println("r2, c2 = " + r2 + "," + c2);
                System.out.println("k, j = " + k + "," + j);
                arrayDeletedColumn[r2][c2] = arrayDeletedRow[k][j];
                r2++;
            }
            c2++;
            r2 = 0;
        }
        return arrayDeletedColumn;
    }
}
