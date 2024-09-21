package datastructures.treecenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeCenter {

    public static void main(String[] args) {

        List<List<Integer>> tree1 = new ArrayList<>();
        tree1.add(List.of(1));
        tree1.add(List.of(3,4,0));
        tree1.add(List.of(3));
        tree1.add(List.of(1,2,6,7));
        tree1.add(List.of(1,5,8));
        tree1.add(List.of(4));
        tree1.add(List.of(3,9));
        tree1.add(List.of(3));
        tree1.add(List.of(4));
        tree1.add(List.of(6));
        List<List<Integer>> tree2 = new ArrayList<>();
        tree2.add(List.of(1));
        tree2.add(List.of(0, 2));
        tree2.add(List.of(1,3,6,9));
        tree2.add(List.of(2,4,5));
        tree2.add(List.of(3));
        tree2.add(List.of(3));
        tree2.add(List.of(2,7,8));
        tree2.add(List.of(6));
        tree2.add(List.of(6));

//        List<Integer> results = getTreeCenter(tree2);
//
//        System.out.println(results);

        List<Integer> results2 = getTreeCenter2(tree1);

        System.out.println(results2);

//        List<Integer> treeCenter = treeCenter(tree1);
//        System.out.println();
    }

    public static List<Integer> getTreeCenter(List<List<Integer>> graph) {
        int n = graph.size();
        int[] degree = new int[n];
        int[] leaves = new int[n];

        for(int i = 0 ; i < n; i++) {
            degree[i] = graph.get(i).size();
            if(degree[i] == 1) {
                leaves[i] = 1;
            }
        }


        while (true) {
            for(int i = 0 ;i < n; i++) {
                boolean isTreeCenter = verifyTreeCenter(degree);

                if(isTreeCenter) {
                    List<Integer> centerNodes = new ArrayList<>();
                    for(int k = 0; k< n; k++) {
                        if(degree[k] >= 0) {
                            centerNodes.add(k);
                        }
                    }
                    return centerNodes;
                }

                if(leaves[i] == 1) {
                    // prune leafs
                    // reduce degree
                    for(int m = 0; m < graph.size(); m++) {
                        for(int k = 0; k < graph.get(m).size(); k++) {
                            if(graph.get(m).get(k) == i) {
                                degree[m] = degree[m] - 1;
                            }
                        }
                    }
                    leaves[i] = 0;
                    degree[i] = -1;
                }

                for(int k = 0; k < n; k++) {
                    if(degree[k] == 1) {
                        leaves[k] = 1;
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static List<Integer> getTreeCenter2(List<List<Integer>> graph) {
        int n = graph.size();
        int[] degree = new int[n];
        List<Integer> leavesIndexes = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            degree[i] = graph.get(i).size();
            if(degree[i] == 1) {
                leavesIndexes.add(i);
            }
        }

        while (true) {
                boolean isTreeCenter = verifyTreeCenter(degree);

                if(isTreeCenter) {
                    List<Integer> centerNodes = new ArrayList<>();
                    for(int k = 0; k< n; k++) {
                        if(degree[k] >= 0) {
                            centerNodes.add(k);
                        }
                    }
                    return centerNodes;
                }

                for(Integer leave : leavesIndexes) {
                    // prune leafs
                    // reduce degree
                    for(int m = 0; m < graph.size(); m++) {
                        for(int k = 0; k < graph.get(m).size(); k++) {
                            if(graph.get(m).get(k) == leave) {
                                degree[m] = degree[m] - 1;
                            }
                        }
                    }
                    degree[leave] = -1;
                }


            leavesIndexes = new ArrayList<>();
            for(int k = 0; k < n; k++) {
                if(degree[k] == 1) {
                    leavesIndexes.add(k);
                }
            }
            System.out.println();
        }
    }



    private static int pickIndexOfLeaves(int[] leaves) {
        for(int i = 0; i< leaves.length; i++) {
            if(leaves[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static boolean verifyTreeCenter(int[] degree) {
        for(int i = 0; i< degree.length; i++) {
            if(degree[i] > 1) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> treeCenter(List<List<Integer>> graph) {
        int n = graph.size();
        int[] degree = new int[n];
        List<Integer> leaves = new ArrayList<>();

        for(int i = 0; i< n; i++) {
            degree[i] = graph.get(i).size();
            if(degree[i] == 0 || degree[i] == 1) {
                leaves.add(i);
                degree[i] = 0;
            }
        }
        int count = leaves.size();

        while (count < n) {
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer node: newLeaves) {
                for(Integer neighbor: graph.get(node)) {
                    degree[neighbor] = degree[neighbor] - 1;
                    if(degree[neighbor] == 1) newLeaves.add(neighbor);
                }
                degree[node] = 0;
            }
            count += newLeaves.size();
            leaves = newLeaves;
        }

        return leaves;
    }
}

class TreeNode {
    private Integer degree;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(Integer degree, TreeNode parent, List<TreeNode> children) {
        this.degree = degree;
        this.parent = parent;
        this.children = children;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
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
