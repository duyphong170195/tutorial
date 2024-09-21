package graphisomorphism;


import datastructures.treecenter.TreeCenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GraphIsomorphism {

    public static void main(String[] args) {

        List<List<Integer>> tree1 = new ArrayList<>();
        tree1.add(List.of(1,2,3)); // 0
        tree1.add(List.of(4,5,0)); // 1
        tree1.add(List.of(6,7,0)); // 2
        tree1.add(List.of(0)); // 3
        tree1.add(List.of(2)); // 4
        tree1.add(List.of(2)); // 5
        tree1.add(List.of(3)); // 6
        tree1.add(List.of(3)); // 7
//        tree1.add(List.of()); // 2
//        tree1.add(List.of(0)); // 3
//        tree1.add(List.of(1)); // 4
//        tree1.add(List.of(1)); // 5
//        tree1.add(List.of(2)); // 6
//        tree1.add(List.of(2)); // 7
//        tree1.add(List.of(3)); // 8
//        tree1.add(List.of(5)); // 9

//        List<Integer> treeCenter = TreeCenter.getTreeCenter(tree1);
//        System.out.println(treeCenter);

//        TreeNode treeNodeLeft1 = new TreeNode(0,null,null);
//        TreeNode treeNodeRight1 = new TreeNode(0,null,null);
//        TreeNode treeNode21 = new TreeNode(0,null,null);
//        TreeNode treeNode22 = new TreeNode(0,null,null);
//
//        TreeNode treeNodeLeft0 = new TreeNode(0,null,null);
//        TreeNode treeNodeRight0 = new TreeNode(0,null,null);
//
//        TreeNode treeNode = new TreeNode(0,null,null);



//        List<Integer> root = tree1.get(0);



        List<List<Integer>> tree3 = new ArrayList<>();
        tree3.add(List.of(1)); // 0
        tree3.add(List.of(0,2,4)); // 1
        tree3.add(List.of(1)); // 2
        tree3.add(List.of(4,5)); // 3
        tree3.add(List.of(1,3)); // 4
        tree3.add(List.of(3)); // 5

        System.out.println(TreeCenter.getTreeCenter2(tree3));



        List<Integer> newParentValues3 = new ArrayList<>();
        newParentValues3.add(4);
        List<Integer> root3 = tree3.get(4);

        System.out.println(build(tree3, root3, newParentValues3));

        List<List<Integer>> tree4 = new ArrayList<>();
        tree4.add(List.of(1)); // 0
        tree4.add(List.of(0,2)); // 1
        tree4.add(List.of(1,4)); // 2
        tree4.add(List.of(4)); // 3
        tree4.add(List.of(2,3,5)); // 4
        tree4.add(List.of(4)); // 5

        System.out.println(TreeCenter.getTreeCenter2(tree4));

        List<Integer> newParentValues4 = new ArrayList<>();
        newParentValues4.add(2);
        List<Integer> root4 = tree4.get(2);

        System.out.println(build(tree4, root4, newParentValues4));

    }

    private static String build(List<List<Integer>> tree, List<Integer> node, List<Integer> newParentValues) {

        if(node.size() == 1) {
            return "()";
        }

        String value = "";
        List<String> strings  = new ArrayList<>();
        for(int i = 0; i < node.size(); i++) {

            if(newParentValues.contains(node.get(i))) {
                continue;
            }
            List<Integer> newParents = new ArrayList<>();
            newParents.addAll(newParentValues);
            newParents.add(node.get(i));

            strings.add(build(tree, tree.get(node.get(i)), newParentValues));
        }
        Collections.sort(strings);
        return "(" + strings.stream().collect(Collectors.joining()) + ")";
    }

    private static boolean checkParent(Integer value, TreeNode parent) {
        if(parent == null) return false;

        if(value.equals(parent.getValue())) return true;

        return checkParent(value, parent.getParent());
    }
}

class TreeNode {
    private Integer value;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(Integer value, TreeNode parent, List<TreeNode> children) {
        this.value = value;
        this.parent = parent;
        this.children = children;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
