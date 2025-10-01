package Trees.medium;

import java.util.LinkedList;
import java.util.Queue;

// import Tree.TreeNode;
public class _01_height_of_binary_tree {
    // dfs
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    //________________________________________________________________________________________________________
    // bfs
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            depth++;
            int prev = q.size();

            for (int i = 0; i < prev; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return depth;
    }
}

/*
 * URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

104. Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:
Input: root = [1,null,2]
Output: 2

 
Constraints:

	The number of nodes in the tree is in the range [0, 104].
	-100 <= Node.val <= 100
 */
