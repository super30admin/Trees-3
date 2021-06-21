// Time Complexity : O(n*n) coz at every node we are creating new list
// Space Complexity :  O(n*n) node times the list we create at every node
public class PathSum {
	   List<List<Integer>> result;
	    int target;
	    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	        result = new ArrayList<>();
	        target = targetSum;
	        if(root == null) return result;
	        helper(root, 0 , new ArrayList<>());
	        return result;
	    }
	    private void helper(TreeNode root, int currSum, List<Integer> path){
	        if(root == null) return;    
	        currSum += root.val;
	        path.add(root.val);
	        helper(root.left, currSum, new ArrayList<>(path));
	        
	        if(root.left == null && root.right == null){
	            if(target == currSum){
	                result.add(path);
	            }
	        }
	        helper(root.right, currSum, new ArrayList<>(path));
	    }
}
