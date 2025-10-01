package Trees.hard;

public class _11_serialize_and_deserialize_B_T {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val).append(' ');
            // sb.append(node.val).append(" ");
            // sb.append(node.val + " "); // creates a new temp string
            // sb.append(node.val + ' '); // *** WRONG -> adds the int value of n.v + (int)' ' then 
            //creates that new (char){...} to the sb

            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;

        String[] nums = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        for (int i=1; i<nums.length; i++) {
            TreeNode node = q.poll();

            if (!nums[i].equals("n")) { // can't say 'n'. It should be a string (Java nonsense)
                node.left = new TreeNode(Integer.parseInt(nums[i]));
                q.offer(node.left);
            }
            if (!nums[++i].equals("n")) {
                node.right = new TreeNode(Integer.parseInt(nums[i]));
                q.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

/*
 * URL: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * https://youtu.be/-YbXySKJsX8

297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 
Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:
Input: root = []
Output: []

 
Constraints:

	The number of nodes in the tree is in the range [0, 104].
	-1000 <= Node.val <= 1000
 */