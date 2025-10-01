package binary_search_trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 1. Initialization & Mapping 🗺️
The first step is to understand the relationships between all the nodes. The code creates two maps:

Map<Integer, TreeNode> valToRoot: This map links each tree's root value to its root node. It's like a directory to quickly find a tree when you need to merge it.

Map<Integer, Integer> indegree: This map counts how many times each node value appears as a child (i.e., not a root). A node that is the root of the final, merged tree will have an "indegree" of 0.

2. Finding the Final Root 🌳
A valid merge can only result in one single tree. The root of this final tree must be a node that isn't a child of any other node.

The code finds this by looking for a tree root in valToRoot whose value has an indegree of 0.

If it finds more than one such root, it's impossible to form a single tree, so it returns null.

If it finds zero such roots (e.g., a cycle), it's also invalid, so it returns null.

3. Merging the Trees 🧩
This is where the actual structural merge happens. The code uses a recursive helper function mergeNodes.

It starts a traversal from the finalRoot.

Whenever it finds a leaf node whose value is also a key in the valToRoot map, it means this leaf is a merge point.

It replaces the leaf node with the corresponding subtree from the map (node.left = subTree.left, node.right = subTree.right).

It then removes the merged tree from the valToRoot map to mark it as "used."

4. Validation ✅
After attempting the merge, the code performs two final checks to ensure the result is valid:

Connectivity Check: It checks if the valToRoot map is empty. If any trees are left in the map, it means they weren't connected to the final tree, so the result is a "forest," not a single tree. This is invalid.

BST Property Check: It performs a final inorder traversal on the merged tree. It confirms that all node values are in strictly increasing order, which is the main rule for a valid BST. If this rule is violated at any point, the tree is invalid.
 */

public class _10_merge_BST_leetcode_1932 {

    public TreeNode canMerge(List<TreeNode> trees) {
        // Map to store root values to their tree nodes for quick lookup.
        Map<Integer, TreeNode> valToRoot = new HashMap<>();
        // Set to count how many times a node value appears (indegree).
        // A root node has an indegree of 0.
        Map<Integer, Integer> indegree = new HashMap<>();

        // Populate the maps.
        for (TreeNode tree : trees) {
            valToRoot.put(tree.val, tree);
            indegree.putIfAbsent(tree.val, 0); // Initialize root's indegree to 0
            if (tree.left != null) {
                indegree.put(tree.left.val, indegree.getOrDefault(tree.left.val, 0) + 1);
            }
            if (tree.right != null) {
                indegree.put(tree.right.val, indegree.getOrDefault(tree.right.val, 0) + 1);
            }
        }

        // Find the root of the final merged tree.
        TreeNode finalRoot = null;
        for (TreeNode tree : trees) {
            // The final root is the one whose value is never a child node.
            if (indegree.get(tree.val) == 0) {
                // If we find more than one possible root, it's invalid.
                if (finalRoot != null) {
                    return null;
                }
                finalRoot = tree;
            }
        }

        // If no root is found, it's invalid.
        if (finalRoot == null) {
            return null;
        }

        // Perform the merge by traversing and replacing leaf nodes.
        // We also count the nodes to ensure all are included.
        // valToRoot is used to track which trees have been merged.
        valToRoot.remove(finalRoot.val);
        if (!mergeNodes(finalRoot, valToRoot)) {
            return null; // Merge created an invalid BST.
        }

        // If there are unmerged trees, it's a forest, not a single tree.
        if (!valToRoot.isEmpty()) {
            return null;
        }

        // Finally, validate the fully merged tree.
        if (isValidBST(finalRoot, new long[]{Long.MIN_VALUE})) {
            return finalRoot;
        }
        return null;
    }

    // Helper function to recursively merge nodes.
    private boolean mergeNodes(TreeNode node, Map<Integer, TreeNode> valToRoot) {
        if (node == null) {
            return true;
        }

        // If the current node is a leaf and also a root of another tree.
        if (node.left == null && node.right == null && valToRoot.containsKey(node.val)) {
            TreeNode subTreeRoot = valToRoot.get(node.val);
            node.left = subTreeRoot.left;
            node.right = subTreeRoot.right;
            valToRoot.remove(node.val); // Mark this tree as merged.
        }

        // Recurse on children.
        return mergeNodes(node.left, valToRoot) && mergeNodes(node.right, valToRoot);
    }

    // Inorder traversal to check for strictly increasing order.
    private boolean isValidBST(TreeNode node, long[] prev) {
        if (node == null) {
            return true;
        }

        // Check left subtree
        if (!isValidBST(node.left, prev)) {
            return false;
        }

        // Check current node against the previous value in the inorder sequence.
        if (node.val <= prev[0]) {
            return false;
        }
        prev[0] = node.val;

        // Check right subtree
        return isValidBST(node.right, prev);
    }
}


/*
 * URL: https://leetcode.com/problems/merge-bsts-to-create-single-bst/description/

1932. Merge BSTs to Create Single BST

You are given n BST (binary search tree) root nodes for n separate BSTs stored in an array trees (0-indexed). Each BST in trees has at most 3 nodes, and no two roots have the same value. In one operation, you can:
Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is equal to the root value of trees[j].
Replace the leaf node in trees[i] with trees[j].
Remove trees[j] from trees.
Return the root of the resulting BST if it is possible to form a valid BST after performing n - 1 operations, or null if it is impossible to create a valid BST.
A BST (binary search tree) is a binary tree where each node satisfies the following property:
Every node in the node's left subtree has a value strictly less than the node's value.
Every node in the node's right subtree has a value strictly greater than the node's value.
A leaf is a node that has no children.

 
Example 1:
Input: trees = [[2,1],[3,2,5],[5,4]]
Output: [3,2,5,1,null,4]
Explanation:
In the first operation, pick i=1 and j=0, and merge trees[0] into trees[1].
Delete trees[0], so trees = [[3,2,5,1],[5,4]].
In the second operation, pick i=0 and j=1, and merge trees[1] into trees[0].
Delete trees[1], so trees = [[3,2,5,1,null,4]].
The resulting tree, shown above, is a valid BST, so return its root.
Example 2:
Input: trees = [[5,3,8],[3,2,6]]
Output: []
Explanation:
Pick i=0 and j=1 and merge trees[1] into trees[0].
Delete trees[1], so trees = [[5,3,8,2,6]].
The resulting tree is shown above. This is the only valid operation that can be performed, but the resulting tree is not a valid BST, so return null.
Example 3:
Input: trees = [[5,4],[3]]
Output: []
Explanation: It is impossible to perform any operations.

 
Constraints:

	n == trees.length
	1 <= n <= 5 * 104
	The number of nodes in each tree is in the range [1, 3].
	Each node in the input may have children but no grandchildren.
	No two roots of trees have the same value.
	All the trees in the input are valid BSTs.
	1 <= TreeNode.val <= 5 * 104.
 */