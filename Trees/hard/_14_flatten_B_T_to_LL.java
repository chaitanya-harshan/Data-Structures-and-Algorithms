package Trees.hard;

public class _14_flatten_B_T_to_LL {

    // Some weird ass post-order traversal technique which is brute force
    TreeNode prev = null; 
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
    //--------------------------------------------------------------------------------------------
    
    // ---------- MORRIS traversal ------------
    // you need to watch morris inorder traversal first
    public void flatten_MORRIS(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            }
            else {
                TreeNode pP = cur.left; // preOrder predecessor
                while (pP.right != null) pP = pP.right;

                pP.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            }
        }
    }

    //--------------------------------------------------------------------------------------------
    // My method
    public void flatten1(TreeNode root) {
        flattenAndFindLeaf(root);
    }

    TreeNode flattenAndFindLeaf(TreeNode root) {
        if (root == null) return null;

        TreeNode leftLeaf = flattenAndFindLeaf(root.left);
        TreeNode rightLeaf = flattenAndFindLeaf(root.right);

        if (leftLeaf == null && rightLeaf == null) return root;
        
        if (leftLeaf != null) {
            leftLeaf.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightLeaf != null) return rightLeaf;
        else return leftLeaf;
    }
}

/*
 * URL: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

114. Flatten Binary Tree to Linked List

Given the root of a binary tree, flatten the tree into a "linked list":
The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

 
Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:
Input: root = []
Output: []
Example 3:
Input: root = [0]
Output: [0]

 
Constraints:

	The number of nodes in the tree is in the range [0, 2000].
	-100 <= Node.val <= 100
	Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */