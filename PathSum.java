//idea:  recrusive solution.
//start from root  and subtract value from sum. Keep on repeating it till we receive leaf node and if sum  is 0 then add root values in list.
//do recursive process for left and right node of root.



//time complexity o(n)
//space complexity is o(n)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:yes 


import java.util.ArrayList;
import java.util.List;

public class PathSum {
	
	//TreeNode class
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int value) {
			val = value;
		}
	}
	
	//getPathSum method calls helper method with parameter root, sum, list and result which is list of list
	public static List<List<Integer>>getPathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		
		helper( root,  sum, list, result);
		
		return result;
		
	}
	
	//helper method to check from root to leaf node weather sum is equal to target sum. And recursive method with left and right node.
	public static void  helper (TreeNode root, int sum,List<Integer> list, List<List<Integer>> result) {
		if(root == null) return;
		
		sum = sum- root.val;
		list.add(root.val);
		if(root.left == null && root.right == null && sum==0) {
			result.add(new ArrayList<>(list));
		}
		
		helper(root.left,sum,list,result);
		helper(root.right, sum ,list, result);
		
		list.remove(list.size()-1);
		
	}
     
	
	 /* Driver program to test the above functions */
    public static void main(String args[])  
    { 
        int sum = 20; 
          
        /* Constructed binary tree is 
              5 
             /  \ 
           4     8
          /    / \
         11    13  7
       
        */
        TreeNode tree = new TreeNode(5); 
      
        tree.left = new TreeNode(4); 
        tree.right = new TreeNode(8); 
        tree.left.left = new TreeNode(11); 
  
        tree.right.right = new TreeNode(7); 
        tree.right.left = new TreeNode(13); 
     
        
        
        List<List<Integer>> result = getPathSum(tree, sum);
        System.out.println(result.size());
   
      for(int i=0;i<result.size();i++) {
    	  System.out.println("There is a root to leaf path with sum " + result.get(i)); 
      }
            

    } 

}
