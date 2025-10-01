package binary_search_trees;

public class _05_kth_smallest_element_in_BST {
    int cnt = 0;
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    void inOrder(TreeNode root, int k) {
        if (root == null) return;
        if (cnt == k) return;// for breaking early if already found

        inOrder(root.left, k);
        if (++cnt == k) ans = root.val;
        inOrder(root.right, k);
    }
}

/*
 * URL: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 
Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

 
Constraints:

	The number of nodes in the tree is n.
	1 <= k <= n <= 104
	0 <= Node.val <= 104
	Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */