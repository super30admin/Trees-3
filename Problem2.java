import java.util.HashMap;

// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//101. Symmetric Tree
//https://leetcode.com/problems/symmetric-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    
    int r = 0;
    int k =0;
    TreeNode temp = null;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    //BidiMap<Integer, Integer> map = new DualHashBidiMap<>(); 
    public boolean isSymmetric(TreeNode root) {
        temp = root;
        helper(root, 0);
        
        if(map.size()%2 ==0 || map.size() == 0) return false;
        if(map.size() == 1) return true;
        
        boolean flag = true;
        
        
        int i = k-1;
        int j = k+1;
        if(j>map.size()-1 && i>=0) return false;
        if(j<map.size() && i<0) return false;
        
        
        while(i>=0 && j<map.size()){
            
            if(i != (map.size()-(j+1))){flag = false; break;}
            if(map.get(i--) != map.get(j++)){flag = false; break;}
            
        }
        return flag;
    }
    
    
    private void helper(TreeNode root, int level){
        if(root == null) return;
        
        helper(root.left, level+1);
        
        if(root == temp){k = r;}
        map.put(r++, root.val+level);
        
        helper(root.right, level+1);
    }
}
