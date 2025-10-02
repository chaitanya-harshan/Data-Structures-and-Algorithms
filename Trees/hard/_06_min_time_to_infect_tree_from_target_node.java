package Trees.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _06_min_time_to_infect_tree_from_target_node {

    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        makeParents(root, parents);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        TreeNode target = findNode(root, start);

        Queue<TreeNode> q = new LinkedList();
        q.offer(target);
        visited.put(target, true);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();

                if (n.left != null && !visited.containsKey(n.left)) {
                    q.offer(n.left);
                    visited.put(n.left, true);
                }
                if (n.right != null && !visited.containsKey(n.right)) {
                    q.offer(n.right);
                    visited.put(n.right, true);
                }
                TreeNode pt = parents.get(n);
                if (pt != null && !visited.containsKey(pt)) {
                    q.offer(pt);
                    visited.put(pt, true);
                }
            }
        }
        return time - 1;
    }

    void makeParents(TreeNode root, HashMap<TreeNode, TreeNode> parents) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parents.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                q.offer(node.right);
            }
        }
    }

    TreeNode findNode(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;

        TreeNode left = findNode(root.left, target);
        TreeNode right = findNode(root.right, target);

        if (left != null) return left; 
        else return right;
    }
}

/*
 * URL: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/

2385. Amount of Time for Binary Tree to Be Infected

You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
Each minute, a node becomes infected if:
The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.

 
Example 1:
Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.
Example 2:
Input: root = [1], start = 1
Output: 0
Explanation: At minute 0, the only node in the tree is infected so we return 0.

 
Constraints:

	The number of nodes in the tree is in the range [1, 105].
	1 <= Node.val <= 105
	Each node has a unique value.
	A node with a value of start exists in the tree.
 */