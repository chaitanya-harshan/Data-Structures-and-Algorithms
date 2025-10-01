package Trees.medium;

public class _12_symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null || t1.val != t2.val) return false;

        boolean left = isMirror(t1.left, t2.right); // *************
        boolean right = isMirror(t1.right, t2.left); // ***********
        return left && right;
    }
}

/*
 * URL: https://leetcode.com/problems/symmetric-tree/description/

101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 
Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

 
Constraints:

	The number of nodes in the tree is in the range [1, 1000].
	-100 <= Node.val <= 100
	Follow up: Could you solve it both recursively and iteratively?
 */