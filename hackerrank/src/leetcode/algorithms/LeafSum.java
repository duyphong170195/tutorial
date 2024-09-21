package leetcode.algorithms;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeafSum {


    public static void main(String[] args) {
        NodePhong node11 = new NodePhong(1, null);
        NodePhong node12 = new NodePhong(1, null);
        NodePhong node1 = new NodePhong(30, List.of(node11, node12));
        NodePhong node21 = new NodePhong(1, null);
        NodePhong node22 = new NodePhong(1, null);
        NodePhong node23 = new NodePhong(1, null);
        NodePhong node2 = new NodePhong(30, List.of(node21, node22, node23));


        NodePhong root = new NodePhong(1, List.of(node1, node2));


        System.out.println(leafSum(root));



    }

    public static Integer leafSum(NodePhong root) {

        if(root == null) return 0;

        if(isLeaf(root)) {
            return root.getValue();
        }
        int total = 0;
        for(NodePhong nodePhong : root.getChildren())  {
            total += leafSum(nodePhong);
        }
        return total;
    }

    public static boolean isLeaf(NodePhong node) {
        if(node.getChildren() == null || node.getChildren().size() == 0) {
            return true;
        }
        return false;
    }


}

class NodePhong {
    private Integer value;

    private List<NodePhong> children;

    public NodePhong() {
    }

    public NodePhong(Integer value, List<NodePhong> children) {
        this.value = value;
        this.children = children;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<NodePhong> getChildren() {
        return children;
    }

    public void setChildren(List<NodePhong> children) {
        this.children = children;
    }
}