package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

	 List<List<Integer>> res = new LinkedList<>();
	    
	    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	        List<Integer> path = new ArrayList<>();
	        dfs(root,path,targetSum);
	        return res;
	    }
	    
	    void dfs(TreeNode root, List<Integer> path, int target) {
	        if(root == null) return;
	        if(root.left == null && root.right == null && root.val == target) {
	            ArrayList<Integer> al = new ArrayList<>(path);
	            al.add(root.val);
	            
	            res.add(al);
	            
	            return;
	        }
	        
	        path.add(root.val);
	        target -= root.val;
	        
	        dfs(root.left,path,target);
	        dfs(root.right,path,target);
	        
	        path.remove(path.size()-1);
	    }
}
