package Trees.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class _08_vertical_order_traversal_bianry_tree {
    // Question isn't clear but we need to sort it by 'row' as well **********
    // pq -> {row, node.val}
    TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (PriorityQueue<int[]> pq_col: map.values()) {
            List<Integer> col = new ArrayList<>();
            while (!pq_col.isEmpty()) {
                col.add(pq_col.poll()[1]);
            }
            res.add(col);
        }
        return res;
    }

    void dfs(TreeNode root, int x, int y) {
        if (root == null) return;

        if (!map.containsKey(x)) map.put(x, new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        }));
        map.get(x).offer(new int[]{y, root.val});

        dfs(root.left, x-1, y+1);
        dfs(root.right, x+1, y+1);
    }
}

/*
 * URL: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

987. Vertical Order Traversal of a Binary Tree

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions 
(row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each 
column index starting from the leftmost column and ending on the rightmost column. 
There may be multiple nodes in the same row and same column. 
In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.

 
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:
Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
1 is at the top, so it comes first.
5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:
Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.

 
Constraints:

	The number of nodes in the tree is in the range [1, 1000].
	0 <= Node.val <= 1000
 */