// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class PathSum_II {
	public class TreeNode {
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
	 List<List<Integer>> result=new ArrayList<>();
	    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	        helper(root,targetSum,new ArrayList(),0);
	        return result;
	    }
	    
	    public void helper(TreeNode root, int targetSum, List<Integer> currList, int currSum){
	        if(root==null){
	            return;
	        }
	        
	        if(root.left==null && root.right==null){
	            currSum+=root.val;
	            currList.add(root.val);
	            if(currSum==targetSum){
	                currSum=0;
	                result.add(new ArrayList(currList));
	            }
	             currList.remove(currList.size()-1);
	             return;
	            
	        }
	        
	        currSum+=root.val;
	        currList.add(root.val);
	        helper(root.left,targetSum,currList,currSum);
	        helper(root.right,targetSum,currList,currSum);
	        currList.remove(currList.size()-1);
	        return;
	        
	    }

}
