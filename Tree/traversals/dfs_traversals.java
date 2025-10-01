package Trees.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class dfs_traversals {
    
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        in_order(root, list);
        result.add(new ArrayList<>(list));
        list.clear();

        pre_order(root, list);
        result.add(new ArrayList<>(list));
        list.clear();

        post_order(root, list);
        result.add(list);

        return result;
    }

//===============================================================================================================================================
    public static void in_order(TreeNode root, List<Integer> list) {
        if (root == null) return;

        in_order(root.left, list);
        list.add(root.val);
        in_order(root.right, list);
    }

    public static void pre_order(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        pre_order(root.left, list);
        pre_order(root.right, list);
    }

    public static void post_order(TreeNode root, List<Integer> list) {
        if (root == null) return;

        post_order(root.left, list);
        post_order(root.right, list);
        list.add(root.val);
    }
//=================================================================================================================================================================

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// ----- Morris Traversal -------- ****************
// https://www.youtube.com/watch?v=PUfADhkq1LI - appna College (watch this)
// https://www.youtube.com/watch?v=80Zug6D1_r4 - Striver 
public List<Integer> inorderTraversal_MORRIS(TreeNode root) {
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
            
            // Creating the thread to connect to 'cur'
            if (IP.right == null) {
                IP.right = cur;
                cur = cur.left;
            }
            else { // Breaking the thread because we have already traversed the left part
                IP.right = null;
                res.add(cur.val);
                cur = cur.right;
            }
            }
        }
        return res;
    }
    //___________________________________________________________________________________________
    
    // Weird stack method
    public List<Integer> inorderTraversal_STACK(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        while (true) {
            if (root != null) {
                st.push(root);
                root = root.left;
            }
            else {
                if (st.empty()) break;
                
                root = st.pop();
                tree.add(root.val);
                root = root.right;
            }
        }
        
        return tree;
    }
    
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    
// ----- Morris Traversal --------
// https://www.youtube.com/watch?v=PUfADhkq1LI - appna College (watch this)
// https://www.youtube.com/watch?v=80Zug6D1_r4 - Striver 
    public List<Integer> preorderTraversal_MORRIS(TreeNode root) {
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

                // Creating the thread to connect to 'cur'
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
