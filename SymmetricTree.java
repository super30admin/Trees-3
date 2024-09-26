package LeetCode;

public class SymmetricTree {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	
	//Approach 1
	class Solution1 {
	    public boolean isSymmetric(TreeNode root) {
	        Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    
	    while (!q.isEmpty()) {
	        TreeNode left = q.poll();
	        TreeNode right = q.poll();
	        if (left == null && right == null) continue;
	        if (left == null || right == null) return false;
	        if (left.val != right.val) return false;
	        q.add(left.left);
	        q.add(right.right);
	        q.add(left.right);
	        q.add(right.left);
	    }
	    return true;
	        
	    }
	}

	/*
	Time Complexity : O(N squared) polling takes O(n)
	Space complexity : O(N)

	*/


	class Solution2 {
	public boolean isSymmetric(TreeNode root){
	    return helper(root,root);
	}

	private boolean helper(TreeNode lt, TreeNode rt)
	    {
	        if(rt== null  && lt == null) return true;
	        if(rt == null || lt == null) return false;
	        return rt.val == lt.val && helper(lt.left,rt.right) && helper(lt.right,rt.left);
	    }
	}

}
//TC : O(n)
//SC : O(h)
