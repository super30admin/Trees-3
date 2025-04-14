// Time Complexity : O(n), where n is the number of nodes
// Space Complexity : O(h) where h = height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Your code here along with comments explaining your approach:
// Defined a TreeNode class to represent each node of the binary tree
// result method performs DFS traversal while maintaining current path and cumulative sum, adding valid paths to result
// pathSum initializes helper structures and calls result to collect all root-to-leaf paths summing to targetSum


import java.util.ArrayList;
import java.util.List;

public class pathSum2 {
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void result(TreeNode root,List<Integer> send,List<List<Integer>> al,int sum,int targetSum)
    {
        if(root!=null)
        {
            send.add(root.val);
            if(root.left==null && root.right==null)
            {
                if(sum+root.val == targetSum)
                {
                    al.add(new ArrayList<>(send));
                }
            }
            result(root.left,send,al,sum+root.val,targetSum);
            result(root.right,send,al,sum+root.val,targetSum);
            send.remove(send.size()-1);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> send = new ArrayList<>();
        result(root,send,al,0,targetSum);
        return al;
    }
}
