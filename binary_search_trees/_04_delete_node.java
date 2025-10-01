package binary_search_trees;

public class _04_delete_node {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) return helper(root);
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val > key) {
                if (cur.left != null && cur.left.val == key) {
                    cur.left = helper(cur.left);
                    break;
                }
                else cur = cur.left;
            }
            else {
                if (cur.right != null && cur.right.val == key) {
                    cur.right = helper(cur.right);
                    break;
                }
                else cur = cur.right;
            }
        }
        return root;
    }

    TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        
        TreeNode rigthChild = root.right;
        TreeNode cur = root.left;

        while (cur.right != null) cur = cur.right;
        cur.right = rigthChild;

        return root.left;
    }
}

/*
 * URL: https://leetcode.com/problems/delete-node-in-a-bst/description/

450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
Search for a node to remove.
If the node is found, delete the node.

 
Example 1:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
Example 2:
Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:
Input: root = [], key = 0
Output: []

 
Constraints:

	The number of nodes in the tree is in the range [0, 104].
	-105 <= Node.val <= 105
	Each node has a unique value.
	root is a valid binary search tree.
	-105 <= key <= 105
	Follow up: Could you solve it with time complexity O(height of tree)?
 */