package binary_search_trees;

public class _02_floor {
    // THink of it as a number line where origin is x, and you're trying to find the element 
    // that is closest to x on the left side of x.
    public static int floorInBST(TreeNode root, int X) {
        int floor = -1;

        while (root != null) {
            if (root.data == X) return root.data;

            if (root.data < X) {
                floor = root.data;
                root = root.right;
            }
            else root = root.left;
        }
        return floor;
    }
}

/*
https://www.naukri.com/code360/problems/floor-from-bst_920457

 * You are given a BST (Binary search tree) with’ N’ number of nodes and a value ‘X’. Your task is to find the greatest value node of the BST which is smaller than or equal to ‘X’.

Note :‘X’ is not smaller than the smallest node of BST .

10 5 15 2 6 -1 -1 -1 -1 -1 -1
For the given BST  and X = 7, the greatest value node of the BST  which is smaller than or equal to  7 is 6.
 */