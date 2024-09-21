package leetcode.algorithms;

public class HeightOfTree {

    public static void main(String[] args) {

        NodeTree nodeTree3left = new NodeTree(null, null, null);
        NodeTree nodeTree2left = new NodeTree(null, nodeTree3left, null);
        NodeTree nodeTree1left = new NodeTree(null, nodeTree2left, null);
        NodeTree nodeTree1right = new NodeTree(null, null, null);
        NodeTree nodeTree1 = new NodeTree(null, nodeTree1left, nodeTree1right);

        System.out.println(solution(nodeTree1));

    }


    public static int solution(NodeTree tree) {
        if(tree == null) {
            return -1;
        }
        int heightRight = 0;
        int max = 0;
        max +=  solution(tree.getLeft()) + 1;
        heightRight += solution(tree.getRight()) + 1;

        return Math.max(max, heightRight);
    }

}

class NodeTree {
    private Integer value;

    private NodeTree left;
    private NodeTree right;

    public NodeTree(Integer value, NodeTree left, NodeTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public NodeTree() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }
}
