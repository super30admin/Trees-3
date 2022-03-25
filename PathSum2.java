import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(n)
class PathSum2 {
	static class TreeNode {	
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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    	result= new ArrayList<>();
    	helper(root, 0, new ArrayList<>(), targetSum);
    	return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path, int targetSum) {
		//base
    	if(root==null) return;
		
    	//logic
    	//action
		sum+=root.val;
		path.add(root.val);
		if(root.left==null && root.right==null && sum==targetSum) {
			result.add(new ArrayList<>(path));
		}			
		//recurse
		helper(root.left, sum, path, targetSum);
		helper(root.right, sum, path, targetSum);		
		//backtrack
		path.remove(path.size()-1);
	}

	// Driver code to test above 
    public static void main(String args[]) {
    	PathSum2 ob = new PathSum2();
    	TreeNode root= new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));	
    	int target=22;
    	
		System.out.print("Root to leaf paths in tree with sum as "+target+": "+ ob.pathSum(root,target));		
    } 
}