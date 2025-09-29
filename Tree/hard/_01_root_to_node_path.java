package Tree.hard;

import java.util.ArrayList;

public class _01_root_to_node_path {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> path = new ArrayList<>();
        findPath(root, path, x);
        return path;
    }

    static boolean findPath(TreeNode root, ArrayList<Integer> path, int x) {
        if (root == null) return false;

        path.add(root.data);
        if (root.data == x) return true;

        if (findPath(root.left, path, x) || findPath(root.right, path, x)) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}

/*
https://www.naukri.com/code360/problems/path-in-a-tree_3843990

 * You are given a binary tree with ‘N’ number of nodes and a node ‘X’. Your task is to print the path from the root node to the given node ‘X’.

A binary tree is a hierarchical data structure in which each node has at most two children.


Example:
Here, for ‘X ’= 7, the output will be 1 3 7.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 10000
1 <= X <= N
All the node values will be in a range from 1 to N.
 */