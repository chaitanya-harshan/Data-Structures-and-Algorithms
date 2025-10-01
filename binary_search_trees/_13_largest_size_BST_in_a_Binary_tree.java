package binary_search_trees;

public class _13_largest_size_BST_in_a_Binary_tree {
    public static int largestBST(TreeNode root) {
        return findLargest(root).size;
    }

    static Node findLargest(TreeNode root) {
        if (root == null) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Node left = findLargest(root.left);
        Node right = findLargest(root.right);

        if (left.max < root.val && root.val < right.min) {
            int newSize = 1 + left.size + right.size;
            // for handling the case where subTree's is null
            int newMin = Math.min(root.val, left.min);
            int newMax = Math.max(root.val, right.max);
            return new Node(newMin, newMax, newSize);
        }

        int newSize = Math.max(left.size, right.size);
        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, newSize);
    }
}

class Node {
    int min, max, size;

    Node(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

/*
 * https://www.naukri.com/code360/problems/largest-bst-subtree_893103
 * 
 * You have been given a Binary Tree of 'N' nodes, where the nodes have integer values. Your task is to return the size of the largest subtree of the binary tree which is also a BST.



A binary search tree (BST) is a binary tree data structure which has the following properties.

• The left subtree of a node contains only nodes with data less than the node’s data.
• The right subtree of a node contains only nodes with data greater than the node’s data.
• Both the left and right subtrees must also be binary search trees.
 */