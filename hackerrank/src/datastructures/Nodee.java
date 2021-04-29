package datastructures;

public class Nodee {

    private int data;
    private Nodee left;
    private Nodee right;

    public Nodee(int data, Nodee left, Nodee right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Nodee getLeft() {
        return left;
    }

    public void setLeft(Nodee left) {
        this.left = left;
    }

    public Nodee getRight() {
        return right;
    }

    public void setRight(Nodee right) {
        this.right = right;
    }



    public void printTreeInOrderTraversal(Nodee nodee, int query, int dept) {
        if (nodee == null) {
            return;
        }

        if(dept % query == 0) {
            Nodee temp  = nodee.getLeft();
            nodee.setLeft(nodee.getRight());
            nodee.setRight(temp);
        }
        // duyet trai
        printTreeInOrderTraversal(nodee.left, query, dept + 1);
        // print node
        System.out.print("data = " + nodee.data + ",");
        // duyet phai
        printTreeInOrderTraversal(nodee.right, query, dept + 1);

    }

//    public void printTreeInOrderTraversal(Nodee nodee) {
//        if (nodee == null) {
//            return;
//        }
//        // duyet trai
//        printTreeInOrderTraversal(nodee.left);
//        // print node
//        System.out.print("data = " + nodee.data + ",");
//        // duyet phai
//        printTreeInOrderTraversal(nodee.right);
//
//    }

    public void swapNodes(int[] queries) {

    }

//    public void duyetTrai(Nodee nodee) {
//        if(nodee.left == null) {
//            System.out.println(nodee.data);
//            return;
//        }
//        duyetPhai(nodee.left);
//
//    }
//    public void duyetPhai(Nodee nodee) {
//        if(nodee.right == null) {
//            System.out.println(nodee.data);
//            return;
//        }
//        duyetPhai(nodee.right);
//    }
}
