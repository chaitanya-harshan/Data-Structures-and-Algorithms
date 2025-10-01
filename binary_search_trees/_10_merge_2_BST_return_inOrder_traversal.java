package binary_search_trees;

import java.util.ArrayList;
import java.util.List;

public class _10_merge_2_BST_return_inOrder_traversal {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // List<Integer> l1 = new ArrayList<>();
        // List<Integer> l2 = new ArrayList<>();
        // dfs(root1, l1);
        // dfs(root2, l2);
        List<Integer> l1 = morrisInorder(root1);
        List<Integer> l2 = morrisInorder(root2);

        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                res.add(l1.get(i++));
            }
            else res.add(l2.get(j++));
        }
        while (i < l1.size()) res.add(l1.get(i++));
        while (j < l2.size()) res.add(l2.get(j++));

        return res;
    }

    // static void dfs(TreeNode root, List<Integer> inOrder) {
    //     if (root == null) return;

    //     dfs(root.left, inOrder);
    //     inOrder.add(root.data);
    //     dfs(root.right, inOrder);
    // }

    static List<Integer> morrisInorder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                inOrder.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode IP = cur.left;
                while (IP.right != null && IP.right != cur) IP = IP.right;

                if (IP.right == null) {
                    IP.right = cur;
                    cur = cur.left;
                }
                else {
                    IP.right = null;
                    inOrder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inOrder;
    }
}

/*
 * https://www.naukri.com/code360/problems/h_920474
 * you can have duplicates (i think) check the question in naukri
 * You are given two binary search trees of integers having ‘N’ and ‘M’ nodes. Return an array that contains elements of both BST in sorted order.



A binary search tree (BST) is a binary tree data structure with the following properties.

• The left subtree of a node contains only nodes with data less than the node’s data.

• The right subtree of a node contains only nodes with data greater than the node’s data.

• Both the left and right subtrees must also be binary search trees.
 */