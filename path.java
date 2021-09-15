// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
import java.util.*;
class TreeNode{
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


public class path{
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        
        helper(root,target,ans,new ArrayList<>());
        return ans;
    }
    
    public void helper(TreeNode root, int target,List<List<Integer>> ans,ArrayList<Integer> temp){
        if(root==null) return;
        
        temp.add(root.val);
        
        if(root.left==null && root.right==null && target-root.val==0){
            ans.add(new ArrayList<>(temp));
        }
        
        helper(root.left,target-root.val,ans,temp);
        helper(root.right,target-root.val,ans,temp);
        temp.remove(temp.size()-1);
    }
}