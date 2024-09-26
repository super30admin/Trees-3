package LeetCode;
import java.util.*;
public class PathSum2 {
	
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
	 
	
	class Solution {
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        
	        
	        List<List<Integer>> answer = new ArrayList<List<Integer>>();
	        HashMap<TreeNode,TreeNode> ancestors = new HashMap();
	        Deque<TreeNode> stack = new LinkedList();
	        Deque<Integer> sumStack = new LinkedList();
	        stack.push(root);
	        sumStack.push(sum);
	        ancestors.put(root,null);
	        
	        while(!stack.isEmpty() && root!=null) {
	            TreeNode node = stack.pop();
	            int val = sumStack.pop();
	            int vAtLvl = val-node.val;
	            if(node.left==null&&node.right==null&&vAtLvl==0) 
	                addToAnswer(node,ancestors,answer);
	            if(node.left!=null) {
	                sumStack.push(val-node.val);
	                ancestors.put(node.left,node);
	                stack.push(node.left);
	            }
	            if(node.right!=null) {
	                sumStack.push(val-node.val);
	                ancestors.put(node.right,node);
	                stack.push(node.right);
	            }
	        }
	        
	        return answer;
	    }
	    
	    
	    private void addToAnswer(TreeNode node,HashMap<TreeNode,TreeNode> ancestors, List<List<Integer>> answer) {
	        List<Integer> path = new ArrayList();
	        path.add(node.val);
	        TreeNode q = ancestors.get(node);
	        while(q!=null) {
	           path.add(q.val);
	           q=ancestors.get(q);
	        }
	        Collections.reverse(path);
	        answer.add(path);
	    }
	        
	    }

	/*
	Time Complexity : O(N squared) reversing the path + adding it to answer
	Space Complexity : O(N)
	*/
	

}


//Approach 2

class Solution { 
    int target;
   public List<List<Integer>> pathSum(TreeNode root, int sum) {
       target = sum;
       List<List<Integer>> res = new ArrayList<>();
       if (root == null) {
           return res;
       }
       List<Integer> path = new ArrayList<>();
       helper(root, res, path, 0);
       return res;
   }
   
   private void helper(TreeNode root, List<List<Integer>> res, List<Integer> path, int sum) {
       if(root == null) {
           return;
       }

       sum += root.val;
       path.add(root.val);
       
       if(root.left == null && root.right == null && sum == target ) {
           res.add(new ArrayList<Integer> (path));
       }
       
       helper(root.left, res, path, sum);
       helper(root.right, res, path, sum);
       path.remove(path.size() - 1); // backtrack
   }
}

//TC : O(N)
//SC : O(n)


