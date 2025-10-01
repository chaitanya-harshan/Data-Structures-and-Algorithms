package Trees.hard;

public class _04_children_sum_property {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        if (root == null) return;
        
        BinaryTreeNode left = root.left;
        BinaryTreeNode right = root.right;
        int child = 0;
        if (left != null) child += left.data;
        if (right != null) child += right.data;
        
        if (child >= root.data) root.data = child;
        else {
            if (left != null) left.data = root.data;
            if (right != null) right.data = root.data;
        }

        changeTree(left);
        changeTree(right);

        int total = 0;
        if (left != null) total += left.data;
        if (right != null) total += right.data;
        if (left != null || right != null) root.data = total;
    }
}

/*
 * Given a binary tree of nodes 'N', you need to modify the value of its nodes, such that the tree holds the Children sum property.

A binary tree is said to follow the children sum property if, for every node of that tree, the value of that node is equal to the sum of the value(s) of all of its children nodes( left child and the right child).

Note :
 1. You can only increment the value of the nodes, in other words, the modified value must be at least equal to the original value of that node.
 2. You can not change the structure of the original binary tree.
 3. A binary tree is a tree in which each node has at most two children.      
 4. You can assume the value can be 0 for a NULL node and there can also be an empty tree.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 10^2
0 <= N <= 10^2
1 <= node.Value <= 10^6

 */