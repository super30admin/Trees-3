import java.util.ArrayList;
import java.util.List;


class TreeNode {
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
class Solution {
	   List<List<Integer>> output;
	    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	        output = new ArrayList<>();
	        int currentsum =0;
	        List<Integer> list = new ArrayList<>();
	        helper(root, currentsum, targetSum, list);
	        return output;
	    }
	    public void helper(TreeNode root, int currentsum, int targetSum, List<Integer> path){

	    //base
	    if(root==null)
	        return;
	    currentsum = currentsum+root.val; 
	    path.add(root.val);
	    if(root.left==null&& root.right==null ){
	        if(currentsum== targetSum)
	            output.add(new ArrayList<>(path));    
	    }
	    //logic
	    helper(root.left, currentsum, targetSum, path);
	    helper(root.right, currentsum, targetSum, path);
	    //backtracking
	    path.remove(path.size() - 1);
	    }
	}
public class PathSum2 {

}