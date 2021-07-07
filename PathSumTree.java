package s30Coding;

import java.util.*;

//Time Complexity :- O(n^2)  where n is number of nodes in the tree.

// Space Complexity :- O(n) where n is the height of the tree

//LeetCode :- yes

public class PathSumTree {
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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, sum, res, path);
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
        if(root==null) return;
        path.add(root.val);
        
        if(root.left==null && root.right==null ){
            if(root.val==sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if(root.left!=null) {
            helper(root.left,sum-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            helper(root.right,sum-root.val,res,path);
            path.remove(path.size()-1);
        }
        
    }
}
