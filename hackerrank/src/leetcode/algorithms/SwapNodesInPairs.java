package leetcode.algorithms;


public class SwapNodesInPairs {

//    public static ListNodeSwap swapPairs(ListNodeSwap head) {
//        if(head.next == null) return head;
//
//        int i =1;
//        ListNodeSwap headTemp = null;
//        ListNodeSwap copyHead = head;
//        ListNodeSwap previousNode = null;
//        ListNodeSwap firstTemp = null;
//        while (copyHead != null) {
//            if(copyHead.next == null) {
//                return headTemp;
//            }
//
//            if(i % 2 == 0) {
//                previousNode = firstTemp;
//                i++;
//                continue;
//            }
//
//            // temp node 1
//            firstTemp = copyHead;
//            // temp node 2
//
//            ListNodeSwap sencondTemp = copyHead.next;
//
//            firstTemp.next = sencondTemp.next;
//
//            sencondTemp.next = firstTemp;
//
//
//            if(i > 2) {
//                previousNode.next = sencondTemp;
//            }
//
//            if(i == 1) {
//                headTemp = sencondTemp;
//            }
//            i++;
//            copyHead = copyHead.next;
//
//        }
//        return headTemp;
//    }
//
//    public static void main(String[] args) {
////        ListNodeSwap a4 = new ListNodeSwap(4);
//        ListNodeSwap a3 = new ListNodeSwap(3);
//        ListNodeSwap a2 = new ListNodeSwap(2, a3);
//        ListNodeSwap a1 = new ListNodeSwap(1, a2);
//
//        ListNodeSwap head = swapPairs(a1);
//        System.out.println(head);
//    }




}


// private string code
// private int page = 0
// private status = 0
// time

// start
// transaction
// lock row
// get page
// page = page + 1
// update
// release lock


// finish check status of sensor

// lock row
// status = status + 1
// update
// release row


// status  == page ==> refresh page = 0, status = 0






