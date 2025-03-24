package Tree.medium;

import java.util.LinkedList;
import java.util.Queue;

// import Tree.TreeNode;

public class _01_height_of_binary_tree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while (!q.isEmpty()) {
            depth++;
            int prev = q.size();

            for (int i=0; i<prev; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return depth;
    }
}

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/