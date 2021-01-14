//Problem 47: Path Sum II
// Time Complexity :O(N),if we don't consider copying the current path list in result list. N stands for number of nodes.
// Space Complexity : (O(H))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

class Solution47 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

private List<List<Integer>> res;
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    
    res = new ArrayList<>();
    
    if(root==null){
        return res;
    }
    
    helper(root,sum,new ArrayList<>());
    
    return res; 
}

 //TC: O(N*N), SC:(O(H))
 private void helper(TreeNode root, int sum, List<Integer> currList){
        
    if(root==null){
        return;
    }
    
    currList.add(root.val);
    sum = sum - root.val;
    
    if(root.left==null && root.right==null && sum==0){
        res.add(new ArrayList<>(currList));
        currList.remove(currList.size()-1);
        return;
    }
    
    helper(root.left,sum,currList);
    helper(root.right,sum,currList);
    currList.remove(currList.size()-1);
}

}
