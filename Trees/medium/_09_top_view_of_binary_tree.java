package Trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _09_top_view_of_binary_tree {

    public static List<Integer> getTopView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // It's used because it automatically keeps the columns sorted.
        Map<Integer, Integer> map = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair current = q.poll();
            TreeNode node = current.node;
            int x = current.x;
            
            // The core logic: If this horizontal distance has NOT been seen before,
            // then this node is the highest one, so add it to the map.
            if (!map.containsKey(x)) map.put(x, node.val);
            
            if (node.left != null) q.add(new Pair(node.left, x-1));
            if (node.right != null) q.add(new Pair(node.right, x+1));
        }
        
        result.addAll(map.values());        
        return result;
    }
}

class Pair {
    TreeNode node;
    int x;

    Pair(TreeNode node, int x) {
        this.node = node;
        this.x = x;
    }
}

// ----- DFS Approach --------------------------------------------------------------------------------
    // static TreeMap<Integer, int[]> map = new TreeMap<>();

    // public static List<Integer> getTopView(TreeNode root) {
    //     dfs(root, 0, 0);
    //     List<Integer> top = new ArrayList<>();

    //     for (int[] element: map.values()) {
    //         top.add(element[1]);
    //     }
    //     return top;
    // }

    // static void dfs(TreeNode root, int x, int y) {
    //     if (root == null) return;

    //     if (!map.containsKey(x)) map.put(x, new int[]{y,root.data});
    //     else {
    //         if (y < map.get(x)[0]) map.put(x, new int[]{y, root.data});
    //     }

    //     dfs(root.left, x-1, y+1);
    //     dfs(root.right, x+1, y+1);
    // }

/*
 * You are given a Binary Tree of 'n' nodes.
https://www.naukri.com/code360/problems/top-view-of-binary-tree_799401

The Top view of the binary tree is the set of nodes visible when we see the tree from the top.



Find the top view of the given binary tree, from left to right.



Example :
Input: Let the binary tree be:

Output: [10, 4, 2, 1, 3, 6]

Explanation: Consider the vertical lines in the figure. The top view contains the topmost node from each vertical line.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
1 2 3 4 5 -1 6 -1 7 -1 -1 8 -1 9 -1 -1 11 10 -1 -1 -1 -1 -1


Sample Output 1:
10 4 2 1 3 6


Explanation of Sample Output 1:
The binary tree is:

Consider the vertical lines in the figure. The top view contains the topmost node from each vertical line.
In test case 1,



Sample Input 2:
1 2 3 4 5 6 7 8 9 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1


Sample Output 2:
8 4 2 1 3 7


Explanation of Sample Output 2:
The binary tree is:

From left to right, the top view of the tree will be [8,4,2,1,3,7], where 9, 5 and 6 will be hidden when we see from the top of the tree.


Expected time complexity :
The expected time complexity is O(n * log(n)).


Constraints:
1 <= 'n' <= 10000
1 <= data in any node <= 10 ^ 6

Time limit: 1 sec
 */