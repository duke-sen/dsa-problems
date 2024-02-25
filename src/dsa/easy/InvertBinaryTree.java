package dsa.easy;

import commons.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    public void invertTreeHelper(TreeNode root) {
        if (root == null)
            return;
        TreeNode leftChild = root.left;
        root.left = root.right;
        root.right = leftChild;
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTree(root);
        System.out.println("done");
    }
}
