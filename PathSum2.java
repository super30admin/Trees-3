import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(N)
//Space Complexity :O(H) height of the tree
//Did this code successfully run on Leetcode :
//Any problem you faced while coding this :No

public class PathSum2 {
	
	 List<List<Integer>> result = new ArrayList<>();
	   
	    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	       
	       if(root==null)
	           return result; 
	        
	        List<Integer> list = new ArrayList<>();
	        helper(root,0,list,targetSum);
	        return result;   
	    }
	    
	    public void helper(TreeNode root,int currSum,List<Integer> path, int targetSum){
	        
	        if(root==null)
	            return;
	        
	        // action 
	        int newSum = currSum+root.val;
	        path.add(root.val);
	        
	        // recurse
	        helper(root.left,newSum,path,targetSum);
	        
	            if(newSum==targetSum && root.left==null && root.right==null)
	            {
	                result.add(new ArrayList<>(path));
	            }
	            
	        helper(root.right,newSum,path,targetSum);
	        // backtrack
	         if(!path.isEmpty())
	             path.remove(path.size()-1);

	    }
}
