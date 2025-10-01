package binary_search_trees;

import java.util.Stack;

public class _11_Two_sum_IV_in_BST {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);
        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i+j < k) i = left.next();
            else if (i+j > k) j = right.next();
            else return true;
        }

        return false;
    }
}

class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    boolean reverse = false;

    BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    int next() {
        TreeNode temp = st.pop();
        if (reverse) pushAll(temp.left);
        else pushAll(temp.right);
        return temp.val;
    }

    void pushAll(TreeNode root) {
        while (root != null) {
            st.push(root);
            if (reverse) root = root.right;
            else root = root.left;
        }
    }
}

/*
 * URL: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

653. Two Sum IV - Input is a BST

Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 
Example 1:
Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:
Input: root = [5,3,6,2,4,null,7], k = 28
Output: false

 
Constraints:

	The number of nodes in the tree is in the range [1, 104].
	-104 <= Node.val <= 104
	root is guaranteed to be a valid binary search tree.
	-105 <= k <= 105
 */