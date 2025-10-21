package Trees.hard;

import java.util.LinkedList;
import java.util.Queue;

public class _03_max_level_order_width_of_binary_tree {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Node> q = new LinkedList();
        q.offer(new Node(root,0));

        while (!q.isEmpty()) {
            int size = q.size();
            int left_idx = q.peek().idx;
            int right_idx = 0;

            for (int i=0; i<size; i++) {
                TreeNode node = q.peek().node;
                int idx = q.poll().idx;

                if (node.left != null) q.offer(new Node(node.left, idx*2+1));
                if (node.right != null) q.offer(new Node(node.right, idx*2+2));

                if (i == size-1) right_idx = idx;
            } 
            max = Math.max(max, right_idx - left_idx + 1);
        }
        return max;
    }

    class Node {
        TreeNode node;
        int idx;

        Node(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
}

/*
 * URL: https://leetcode.com/problems/maximum-width-of-binary-tree/description/

662. Maximum Width of Binary Tree

Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes 
(the leftmost and rightmost non-null nodes), where the null nodes between 
the end-nodes that would be present in a complete binary tree extending down 
to that level are also counted into the length calculation.
It is guaranteed that the answer will in the range of a 32-bit signed integer.

 
Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:
Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).

 
Constraints:

	The number of nodes in the tree is in the range [1, 3000].
	-100 <= Node.val <= 100
 */