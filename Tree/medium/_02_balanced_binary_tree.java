package Tree.medium;

public class _02_balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;

        int left = depth(root.left);
        int right = depth(root.right);
        if (left == -1 || right == -1) return -1;

        if (Math.abs(left-right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}

/*
 * 110. Balanced Binary Tree
https://leetcode.com/problems/balanced-binary-tree/description/

Given a binary tree, determine if it is height-balanced.
A height-balanced binary tree is a binary tree in which the depth 
of the two subtrees of every node never differs by more than one.

 
Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */