package binary_search_trees;

public class _01_ceil {
    // THink of it as a number line where origin is x, and you're trying to find the element 
    // that is closest to x on the right side of x.
    public int findCeil(TreeNode root, int x) {
        int ceil = -1;

        while (root != null) {
            if (root.data == x) return root.data;

            if (root.data < x) root = root.right;
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}

/*
https://www.naukri.com/code360/problems/ceil-from-bst_920464

 * Given a root of binary search tree and a key(node) value, find the ceil value for that particular key value.

Ceil Value Node: Node with the smallest data larger than or equal to the key value.
If a particular floor or ceil value is not present then output -1.
 */