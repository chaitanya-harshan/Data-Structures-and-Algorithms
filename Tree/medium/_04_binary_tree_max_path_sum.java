package Tree.medium;

public class _04_binary_tree_max_path_sum {
    
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs_sum(root);
        return max;
    }

    int dfs_sum(TreeNode root) {
        if (root == null) return 0;

        int left = dfs_sum(root.left);
        int right = dfs_sum(root.right);

        int diameter_sum = root.val;
        if (left > 0) diameter_sum += left;
        if (right > 0) diameter_sum += right;
        max = Math.max(max, diameter_sum);

        return root.val + Math.max(0, Math.max(left, right));
    }
}

/*
 * 124. Binary Tree Maximum Path Sum
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000

 */