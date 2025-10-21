package Trees.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _05_print_nodes_at_distance_k_in_B_tree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // if (k == 0) return new ArrayList<>(Arrays.asList(target.val));
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        makeParents(root, parent);

        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList();
        q.offer(target);
        visited.put(target, true);

        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k) break; // this is here because to handle case k = 0

            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && !visited.containsKey(node.left)) {
                    q.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && !visited.containsKey(node.right)) {
                    q.offer(node.right);
                    visited.put(node.right, true);
                }
                TreeNode pt = parent.get(node);
                if (pt != null && !visited.containsKey(pt)) {
                    q.offer(pt);
                    visited.put(pt, true);
                }
            }
            distance++;
            // if (distance == k) break;
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            res.add(q.poll().val);
        }
        return res;
    }

    void makeParents(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
}

/*
 * URL: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

863. All Nodes Distance K in Binary Tree

Given the root of a binary tree, the value of a target node target, and an integer k, 
return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.

 
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:
Input: root = [1], target = 1, k = 3
Output: []

 
Constraints:

	The number of nodes in the tree is in the range [1, 500].
	0 <= Node.val <= 500
	All the values Node.val are unique.
	target is the value of one of the nodes in the tree.
	0 <= k <= 1000
 */