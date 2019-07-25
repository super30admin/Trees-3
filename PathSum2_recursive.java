package trees_3;

import java.util.ArrayList;
import java.util.List;

/*
Idea : 1. We go to the Depths of the tree, path by path.
	   2. Keep on subtracting the value of node from the sum and traverse along left and right paths of the tree.
 
Time Complexity : O(n) where n is the number of nodes
Space Complexity : O(n) as we have traverse all the tree nodes.
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

public class PathSum2_recursive {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, res, path);
        return res;
    }
    
    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
        if(root==null) return;
        path.add(root.val);
        
        if(root.left==null && root.right==null ){
            if(root.val==sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if(root.left!=null) {
            dfs(root.left,sum-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            dfs(root.right,sum-root.val,res,path);
            path.remove(path.size()-1);
        }
        
    }
}
