package general;

public class LargestBSTSubtree {

}


/**
 * Problem Link : https://leetcode.com/problems/largest-bst-subtree/
 * Source repo : https://github.com/arkadev-gh/dsa-problems/blob/master/src/main/java/com/general/largestBSTSubtree/LargestBSTSubtree.java
 */
class BinaryTree {

    private static final int EMPTY_TREE_SIZE = 0, INVALI_BST_SIZE = -1;
    private static int maxBstSize = 0;
    Node root;

    // Create a binary tree with a root node value
    public BinaryTree() {
        root = new Node();
    }

    public static int largestBst(Node root) {
        findLargestBst(root);
        return maxBstSize;
    }

    private static NodeInfo findLargestBst(Node root) {
        if (root == null) {
            return new NodeInfo(0, 0, EMPTY_TREE_SIZE);
        }

        NodeInfo left = findLargestBst(root.left);
        NodeInfo right = findLargestBst(root.right);

        NodeInfo current = new NodeInfo();

        // Check if left side is a valid BST
        boolean leftCheck = (left.size > 0 && left.max < root.data) || (left.size == EMPTY_TREE_SIZE);

        // Check if right side is a valid BST
        boolean rightCheck = (right.size > 0 && right.min > root.data) || (right.size == EMPTY_TREE_SIZE);

        // If current tree is BST, then data related to max and min are relevant
        if (leftCheck && rightCheck) {

            current.max = (right.size > 0) ? right.max : root.data;
            current.min = (left.size > 0) ? left.min : root.data;
            current.size = left.size + right.size + 1;
            maxBstSize = Math.max(maxBstSize, current.size);
        }

        // Else all of the above are irrelevant
        else current.size = INVALI_BST_SIZE;

        return current;
    }

    public static void main(String[] args) {
        // Create the tree
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.Node(50);
        tree.root.left = new BinaryTree.Node(10);
        tree.root.right = new BinaryTree.Node(60);
        tree.root.left.left = new BinaryTree.Node(5);
        tree.root.left.right = new BinaryTree.Node(20);
        tree.root.right.left = new BinaryTree.Node(55);
        tree.root.right.left.left = new BinaryTree.Node(45);
        tree.root.right.right = new BinaryTree.Node(70);
        tree.root.right.right.left = new BinaryTree.Node(65);
        tree.root.right.right.right = new BinaryTree.Node(80);

        System.out.println(BinaryTree.largestBst(tree.root));
    }

    // Static class to represent a node
    static class Node {
        int data;
        Node left, right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    // A static nested class wrapper for maintaining Node information
    static class NodeInfo {
        int max, min, size;

        public NodeInfo(int max, int min, int size) {
            this.max = max;
            this.min = min;
            this.size = size;
        }

        public NodeInfo() {
        }
    }
}
