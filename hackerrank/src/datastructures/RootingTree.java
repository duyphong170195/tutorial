package datastructures;

import java.util.ArrayList;
import java.util.List;

public class RootingTree {


    public static void main(String[] args) {
        List<List<Integer>> linkedListArrayList = new ArrayList<>();
        linkedListArrayList.add(List.of(1,2));
        linkedListArrayList.add(List.of(0,3));
        linkedListArrayList.add(List.of(0,3));
        linkedListArrayList.add(List.of(1,2));

        TreeNode treeNode = rootTree(linkedListArrayList, 0);
        System.out.println(treeNode);
    }


    public static TreeNode rootTree(List<List<Integer>> graph, Integer rootId) {

        TreeNode root = new TreeNode(rootId, null, new ArrayList<>());

        List<Integer> parents = new ArrayList<>();
        parents.add(rootId);
//        buildTree(graph, root, null, parents);
        buildTree(graph, root, parents);
        return root;
    }

    private static void buildTree(List<List<Integer>> graph, TreeNode node, TreeNode parent, List<Integer> parentValues) {
        for(Integer value : graph.get(node.getValue())) {
            if(parentValues.contains(value)) continue;

            TreeNode child = new TreeNode();
            child.setValue(value);
            child.setParent(node);
            child.setChildren(new ArrayList<>());

            node.getChildren().add(child);

            List<Integer> newParentValues = new ArrayList<>();
            newParentValues.addAll(parentValues);
            newParentValues.add(child.getValue());

            buildTree(graph, child, node, new ArrayList<>(newParentValues));
        }
    }

    public static void buildTree(List<List<Integer>> graph, TreeNode node, List<Integer> parentValues) {
        for(Integer value : graph.get(node.getValue())) {
            if(parentValues.contains(value)) continue;

            TreeNode child = new TreeNode();
            child.setValue(value);
            child.setChildren(new ArrayList<>());

            node.getChildren().add(child);

            List<Integer> newParentValues = new ArrayList<>();
            newParentValues.addAll(parentValues);
            newParentValues.add(child.getValue());

            buildTree(graph, child, new ArrayList<>(newParentValues));
        }
    }

    private static void buildTree(List<List<Integer>> graph, TreeNode node, TreeNode parent) {
        for(Integer value : graph.get(node.getValue())) {
            if(parent != null && checkParent(value, parent)) continue;

            TreeNode child = new TreeNode();
            child.setValue(value);
            child.setParent(node);
            child.setChildren(new ArrayList<>());

            node.getChildren().add(child);

            buildTree(graph, child, node);
        }
    }

    private static boolean checkParent(Integer value, TreeNode parent) {
        if(parent == null) return false;

        if(value.equals(parent.getValue())) return true;

        return checkParent(value, parent.getParent());
    }
}



