package Trees.hard;

import java.util.ArrayList;
import java.util.List;

public class _13_morris_inorder_traversal {
    
    // ----- Morris Traversal --------
    // https://www.youtube.com/watch?v=PUfADhkq1LI - appna College (watch this)
    // https://www.youtube.com/watch?v=80Zug6D1_r4 - Striver 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode IP = cur.left; // InOrder Predecessor
                while (IP.right != null && IP.right != cur) IP = IP.right; // find IP

                // Creating the thread to connect to 'cur'
                if (IP.right == null) {
                    IP.right = cur;
                    cur = cur.left;
                }
                else { // Breaking the thread because we have already traversed the left part
                    IP.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}

/*
 * URL: https://leetcode.com/problems/binary-tree-inorder-traversal/description/

94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 
Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]
Explanation:
Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]
Explanation:
Example 3:
Input: root = []
Output: []
Example 4:
Input: root = [1]
Output: [1]

 
Constraints:

	The number of nodes in the tree is in the range [0, 100].
	-100 <= Node.val <= 100
	Follow up: Recursive solution is trivial, could you do it iteratively?
 */