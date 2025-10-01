package binary_search_trees;

import java.util.ArrayList;
import java.util.List;

public class _10_merge_2_BST_return_treeNode {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Step 1: Get sorted lists from both trees using in-order traversal.
        List<Integer> list1 = new ArrayList<>();
        inOrderTraversal(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        inOrderTraversal(root2, list2);

        // Step 2: Merge the two sorted lists into one.
        List<Integer> mergedList = mergeSortedLists(list1, list2);

        // Step 3: Build a balanced BST from the final merged list.
        return sortedListToBST(mergedList, 0, mergedList.size() - 1);
    }

    /**
     * Performs in-order traversal to get a sorted list of node values.
     */
    private void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }

    /**
     * Merges two sorted lists into a single sorted list.
     */
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both lists and add the smaller element to the result.
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }

        // Add any remaining elements from list1.
        while (i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }

        // Add any remaining elements from list2.
        while (j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }

        return merged;
    }

    /**
     * Converts a sorted list into a height-balanced BST.
     */
    private TreeNode sortedListToBST(List<Integer> list, int start, int end) {
        // Base case
        if (start > end) {
            return null;
        }

        // The middle element of the list becomes the root.
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        // The left half of the list forms the left subtree.
        root.left = sortedListToBST(list, start, mid - 1);

        // The right half of the list forms the right subtree.
        root.right = sortedListToBST(list, mid + 1, end);

        return root;
    }
}
