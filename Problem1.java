// Time Complexity :O(n)
// Space Complexity :O(N) + O(K+C) C some constant that is path node having sum of target

// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : a bit different coding pattern i tried which i got stuck into


// Your code here along with comments explaining your approach
// create two lists  one is list of lsit and one is list
//then go in recursion send root if root==null return
// if root's left and right null then check if sum of that path is equal to target if yes then add to new result list
//if not recurse if we come back when sum not equal to target remove that added root value from list

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     
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
class Problem1 {
	

	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>>outputres= new ArrayList<>();
	        List<Integer> res=new ArrayList<Integer>();
	        if(root==null)
	            return outputres;
	        
	        helper(root,sum,0,outputres,res);
	        return outputres;
	    }
	    
	    private void helper(TreeNode root,int sum ,int currsum,List<List<Integer>> resot,List<Integer> res){
	        //base
	     if(root==null)
	         return;
	        
	        //logic
	        if(root.left==null && root.right==null){
	            if(currsum+root.val==sum){
	                List<Integer> temp= new ArrayList<>(res);
	                temp.add(root.val);
	                resot.add(temp);
	            }
	        }
	        
	        res.add(root.val);
	        helper(root.left,sum,currsum+root.val,resot,res);
	        helper(root.right,sum,currsum+root.val,resot,res); 
	        res.remove(res.size()-1);
	    
	    }
	
}