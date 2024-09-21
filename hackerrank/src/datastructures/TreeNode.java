package datastructures;

import java.util.List;

public class TreeNode {
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

    public TreeNode(Integer value, List<TreeNode> children) {
        this.value = value;
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
