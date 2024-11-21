import java.util.ArrayList;
import java.util.List;

public class PathSum {
	
	 List<List<Integer>> list = new ArrayList<>();
	    
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        
	        helper(root, 0, new ArrayList<>(), sum);
	        return list;
	    }
	    
	    private void helper(TreeNode root, int sumSoFar, List<Integer> li,int sum){
	        
	        if(root == null){
	            return;
	        }
	        
	        sumSoFar = sumSoFar + root.val;
	        li.add(root.val);
	        
	        if(root.left == null && root.right == null){
	            if(sum == sumSoFar){
	                list.add(li);
	            }
	        }
	        
	        
	        helper(root.left, sumSoFar, new ArrayList<>(li), sum);
	        helper(root.right, sumSoFar, new ArrayList<>(li), sum);
	    }

}
