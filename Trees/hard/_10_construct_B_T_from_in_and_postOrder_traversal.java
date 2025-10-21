package Trees.hard;

import java.util.HashMap;

public class _10_construct_B_T_from_in_and_postOrder_traversal {
    int[] postorder, inorder;
    HashMap<Integer, Integer> in_map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        for (int i=0; i<inorder.length; i++) in_map.put(inorder[i], i);

        return buildTree(0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode buildTree(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int rootIdx = in_map.get(postorder[pe]);
        int numsRight = ie - rootIdx;

        root.right = buildTree(rootIdx+1, ie, pe - numsRight, pe-1);
        root.left = buildTree(is, rootIdx-1, ps, pe - numsRight - 1);
        return root;
    }
}

/*
 * URL: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

106. Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 
Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

 
Constraints:

	1 <= inorder.length <= 3000
	postorder.length == inorder.length
	-3000 <= inorder[i], postorder[i] <= 3000
	inorder and postorder consist of unique values.
	Each value of postorder also appears in inorder.
	inorder is guaranteed to be the inorder traversal of the tree.
	postorder is guaranteed to be the postorder traversal of the tree.
 */