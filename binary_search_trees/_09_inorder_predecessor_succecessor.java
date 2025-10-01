package binary_search_trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _09_inorder_predecessor_succecessor {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        if (root == null) new ArrayList<>(Arrays.asList(-1,-1));
        int predecessor = -1;
        int successor = -1;

        while (root != null) {
            if (root.data > key) {
                successor = root.data;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        while (root != null) {
            if (root.data < key) {
                predecessor = root.data;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return new ArrayList<>(Arrays.asList(predecessor, successor));
    }
}
/*
https://www.naukri.com/code360/problems/predecessor-and-successor-in-bst_893049
 * You have been given a binary search tree of integers with ‘N’ nodes. 
 * You are also given 'KEY' which represents data of a node of this tree.
Your task is to return the predecessor and successor of the given node in the BST.

Note:
1. The predecessor of a node in BST is that node that will be visited just before the given node in the inorder traversal of the tree. If the given node is visited first in the inorder traversal, then its predecessor is NULL.

2. The successor of a node in BST is that node that will be visited immediately after the given node in the inorder traversal of the tree. If the given node is visited last in the inorder traversal, then its successor is NULL.

3. The node for which the predecessor and successor will not always be present. If not present, you can hypothetically assume it's position (Given that it is a BST) and accordingly find out the predecessor and successor.

4. A binary search tree (BST) is a binary tree data structure which has the following properties.
     • The left subtree of a node contains only nodes with data less than the node’s data.
     • The right subtree of a node contains only nodes with data greater than the node’s data.
     • Both the left and right subtrees must also be binary search trees.
 */