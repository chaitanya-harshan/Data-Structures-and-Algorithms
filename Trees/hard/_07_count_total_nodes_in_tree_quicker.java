package Trees.hard;

public class _07_count_total_nodes_in_tree_quicker {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = leftDepth(root);
        int right = rightDepth(root);

        // if (left == right) return (1 << left)-1;
        if (left == right) return (2 << left)-1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int leftDepth(TreeNode root) {
        int depth = 0;
        // while (root != null) {
        while (root.left != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    int rightDepth(TreeNode root) {
        int depth = 0;
        // while (root != null) {
        while (root.right != null) {
            depth++;
            root = root.right;
        }
        return depth;
    }
}

// 1 0
// 3 2-1
// 7 3-1


/*
 * URL: https://leetcode.com/problems/count-complete-tree-nodes/description/

222. Count Complete Tree Nodes

Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a 
complete binary tree, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.

 
Example 1:
Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:
Input: root = []
Output: 0
Example 3:
Input: root = [1]
Output: 1

 
Constraints:

	The number of nodes in the tree is in the range [0, 5 * 104].
	0 <= Node.val <= 5 * 104
	The tree is guaranteed to be complete.
 */