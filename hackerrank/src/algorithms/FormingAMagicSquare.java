package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FormingAMagicSquare {

    // a magic square where the sum of any row, column, is always equal to the same number

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here

        List<Integer> cornerOfSquare = Arrays.asList(2, 4, 6, 8);
        List<Integer> oddMid  = Arrays.asList(1, 3, 7 , 9);
        Integer center = 5;
        LinkedList<Integer> linkedList = new LinkedList<>();
        int indexRow1[]= {-1, -1, -1};
        int indexRow2[]= {-1, -1, -1};
        int indexRow3[]= {-1, -1, -1};
        List<Integer> indexList = s.get(0);
        List<Integer> indexList2 = s.get(1);
        List<Integer> indexList3 = s.get(2);
        for (int i = 0; i< indexList.size(); i++) {
            if(i%2 == 0)

            {
                // row 1
                if(cornerOfSquare.contains(indexList.get(i))) {
                    cornerOfSquare.remove(indexList.get(i));
                } else {
                    indexRow1[i] = 1;
                }
                // row 3
                if(cornerOfSquare.contains(indexList3.get(i))) {
                    cornerOfSquare.remove(indexList3.get(i));
                } else {
                    indexRow3[i] = 1;
                }

                // row 2
                if(oddMid.contains(indexList2.get(i))) {
                    oddMid.remove(indexList2.get(i));
                } else {
                    indexRow2[i] = 1;
                }
            } else {
                // row 1
                if(oddMid.contains(indexList.get(i))) {
                    oddMid.remove(indexList.get(i));
                } else {
                    indexRow1[i] = 1;
                }
                // row 3
                if(oddMid.contains(indexList3.get(i))) {
                    oddMid.remove(indexList3.get(i));
                } else {
                    indexRow3[i] = 1;
                }

                // row 2
                if(oddMid.contains(indexList2.get(i))) {
                    oddMid.remove(indexList2.get(i));
                } else {
                    indexRow2[i] = 1;
                }
            }


        }



        // row 0
        if(cornerOfSquare.contains(indexList.get(0))) {
            cornerOfSquare.remove(indexList.get(0));
        } else {
            indexRow1[0] = 1;
        }
        if(cornerOfSquare.contains(indexList.get(1))) {
            cornerOfSquare.remove(indexList.get(1));
        } else {
            indexRow1[1] = 1;
        }
        if(cornerOfSquare.contains(indexList.get(2))) {
            cornerOfSquare.remove(indexList.get(2));
        } else {
            indexRow1[2] = 1;
        }
        // row 1
        if(oddMid.contains(indexList2.get(0))){
            cornerOfSquare.remove(indexList2.get(0));
        } else {
            indexRow2[0] = 1;
        }
        if(center.equals(center)) {
            cornerOfSquare.remove(indexList2.get(1));
        } else {
            indexRow2[1] = 1;
        }
        if(oddMid.contains(indexList2.get(2))) {
            cornerOfSquare.remove(indexList2.get(2));
        } else {
            indexRow2[2] = 1;
        }

        // row 2
        // row 0
        if(cornerOfSquare.contains(indexList3.get(0))) {
            cornerOfSquare.remove(indexList3.get(0));
        } else {
            indexRow3[0] = 1;
        }
        if(cornerOfSquare.contains(indexList3.get(1))) {
            cornerOfSquare.remove(indexList3.get(1));
        } else {
            indexRow3[1] = 1;
        }
        if(cornerOfSquare.contains(indexList3.get(2))) {
            cornerOfSquare.remove(indexList3.get(2));
        } else {
            indexRow3[2] = 1;
        }


//        if(indexList.get(0) + indexList.get(2) + indexList3.get(0) +  indexList3.get(2) != 20) {
//            if(cornerOfSquare.contains(indexList.get(0))) {
//                cornerOfSquare.remove(indexList.get(0));
//            }
//            if(cornerOfSquare.contains(indexList.get(2))) {
//                cornerOfSquare.remove(indexList.get(2));
//            }
//            if(cornerOfSquare.contains(indexList3.get(0))) {
//                cornerOfSquare.remove(indexList3.get(0));
//            }
//            if(cornerOfSquare.contains(indexList3.get(2))) {
//                cornerOfSquare.remove(indexList3.get(2));
//            }
//        }
//        if(indexList.get(1) + indexList2.get(0) + indexList2.get(2) +  indexList3.get(1) != 20) {
//
//        }

//        for(int i = 0; i < s.size(); i++) {
//            List<Integer> indexList = s.get(i);
//            for(int j = 0; j< indexList.size(); j++) {
//                if(indexList.get(j).co)
//            }
//        }
    }
}
