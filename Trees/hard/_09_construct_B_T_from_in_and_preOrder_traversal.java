package Trees.hard;

import java.util.HashMap;

public class _09_construct_B_T_from_in_and_preOrder_traversal {
    int[] preorder, inorder;
    HashMap<Integer, Integer> in_map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i=0; i<inorder.length; i++) in_map.put(inorder[i], i);

        return buildTree(0, inorder.length-1, 0, preorder.length-1);
    }

    private TreeNode buildTree(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return null;

        TreeNode root = new TreeNode(preorder[ps]);
        int rootIdx = in_map.get(preorder[ps]);
        int numsLeft = rootIdx - is;

        root.left = buildTree(is, rootIdx-1, ps+1, ps + numsLeft);
        root.right = buildTree(rootIdx+1, ie, ps + numsLeft + 1, pe);
        return root;
    }
}

/*
 * URL: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 
Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

 
Constraints:

	1 <= preorder.length <= 3000
	inorder.length == preorder.length
	-3000 <= preorder[i], inorder[i] <= 3000
	preorder and inorder consist of unique values.
	Each value of inorder also appears in preorder.
	preorder is guaranteed to be the preorder traversal of the tree.
	inorder is guaranteed to be the inorder traversal of the tree.
 */