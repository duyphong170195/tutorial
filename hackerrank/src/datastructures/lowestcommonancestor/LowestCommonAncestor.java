package datastructures.lowestcommonancestor;

import datastructures.RootingTree;
import datastructures.TreeNode;
import datastructures.treecenter.TreeCenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        List<List<Integer>> tree = new ArrayList<>();
        tree.add(List.of(1, 2)); // 0
        tree.add(List.of(0, 3)); // 1
        tree.add(List.of(0, 4, 5)); // 2
        tree.add(List.of(1)); // 3
        tree.add(List.of(2, 6)); // 4
        tree.add(List.of(2)); // 5
        tree.add(List.of(4)); // 6

        int[] last = new int[tree.size()];


        List<Integer> centers = TreeCenter.getTreeCenter2(tree);
        System.out.println(centers);

        TreeNode root =  RootingTree.rootTree(tree, centers.get(0));

        buildLastOccurence(root, last, 0);

        System.out.println(last);

        System.out.println(root);
        List<Integer> deptOfNodes = new ArrayList<>();
        System.out.println();

        System.out.println(
                getLowestCommonAncestor(buildNodes(root), buildDept(root, 0), List.of(6,5))
        );

    }

//    public static Integer lowestCommonAncestor(TreeNode root) {
//        List<Integer> deptOfNodes = new ArrayList<>();
//        List<Integer> nodes = new ArrayList<>();
//
//
//    }

    private static void buildDept(TreeNode root, List<Integer> deptOfNodes, Integer currentDept) {
        deptOfNodes.add(currentDept);
        for(TreeNode child: root.getChildren()) {
            buildDept(child, deptOfNodes, currentDept + 1);
            deptOfNodes.add(currentDept);
        }
    }

    private static List<Integer> buildDept(TreeNode root, Integer currentDept) {
        if(root.getChildren().size() == 0) {
            return List.of(currentDept);
        }
        List<Integer> deptOfNodes = new ArrayList<>();
        deptOfNodes.add(currentDept);
        for(TreeNode child: root.getChildren()) {
            deptOfNodes.addAll(buildDept(child, currentDept + 1));
            deptOfNodes.add(currentDept);
        }
        return deptOfNodes;
    }

    private static Integer getLowestCommonAncestor(List<Integer> nodes, List<Integer> dept, List<Integer> choosingNodes) {

        List<Integer> indexOfNodes = new ArrayList<>();
        for(int i = 0; i < nodes.size(); i++) {
            if(choosingNodes.contains(nodes.get(i))) {
                indexOfNodes.add(i);
            }
        }

        return findIndexOfMinDeptInRange(indexOfNodes, dept, nodes);

    }

    private static Integer findIndexOfMinDeptInRange(List<Integer> indexOfNodes, List<Integer> dept, List<Integer> nodes) {

        indexOfNodes = indexOfNodes.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        if(indexOfNodes.size() == 1) {
            return nodes.get(indexOfNodes.get(0));
        } else {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i = indexOfNodes.get(0); i <= indexOfNodes.get(1); i++) {
                if(min > dept.get(i)) {
                    min = dept.get(i);
                    index = i;
                }
            }

            return nodes.get(index);
        }
    }

    private static List<Integer> buildNodes(TreeNode root) {

        if(root.getChildren().size() == 0) {
            return List.of(root.getValue());
        }

        List<Integer> nodes = new ArrayList<>();
        nodes.add(root.getValue());

        for(TreeNode child: root.getChildren()) {
            nodes.addAll(buildNodes(child));
            nodes.add(root.getValue());
        }
        return nodes;
    }

    private static void buildLastOccurence(TreeNode root, int[] lastOccurenceIndex, int current) {

//        if(root.getChildren().size() == 0) {
//            return List.of(root.getValue());
//        }
//
//        List<Integer> nodes = new ArrayList<>();
//        nodes.add(root.getValue());
//        lastOccurenceIndex[root.getValue()] = nodes.size();
//        for(TreeNode child: root.getChildren()) {
//            nodes.addAll(buildNodes(child));
//            nodes.add(root.getValue());
//        }
//        return nodes;

        if(root.getChildren().size() == 0) {
            return;
        }

        if (current == 0) lastOccurenceIndex[root.getValue()] = current;

        for(TreeNode child: root.getChildren()) {
            current = current + 1;
            lastOccurenceIndex[child.getValue()] = current;
            buildLastOccurence(child, lastOccurenceIndex, current);
        }

        current = current + 1;
        lastOccurenceIndex[root.getValue()] = current;
        return;
    }


//    private static void buildDeptAndNodes(TreeNode root, List<Integer> deptOfNodes, List<Integer> nodes) {
//
//
//        for(TreeNode children: root.getChildren()) {
//            buildDeptAndNodes();
//        }
//    }
}
// n == 0 ==> return 1;
// n < 0 ==> return 0
// 2*f(n-1) + f(n-2) + f(n-4)
