package Trees.hard;

import java.util.ArrayList;
import java.util.List;

public class _12_morris_preOrder_traversal {
    
    // ----- Morris Traversal --------
    // https://www.youtube.com/watch?v=PUfADhkq1LI - appna College (watch this)
    // https://www.youtube.com/watch?v=80Zug6D1_r4 - Striver 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode IP = cur.left; // InOrder Predecessor
                while (IP.right != null && IP.right != cur) IP = IP.right; // find IP

                if (IP.right == null) {
                    IP.right = cur;
                    res.add(cur.val);  // this is the only change from In-Order MORRIS traversal
                    cur = cur.left;
                }
                else { // Breaking the thread because we have already traversed the left part
                    IP.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}

// No Leetcode link. just do InOrder problem and extropolate