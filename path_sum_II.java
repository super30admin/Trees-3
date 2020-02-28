// Time Complexity : O(N) each nodes will be visited once
// Space Complexity : O(log(N)) if we don't consider result. 
	//The calls in calling stack may reach h if h denotes to the length of the deepest path in the tree. 
	//So it’s space complexity is O(h). Or you can say O(logn) because h is bounded by logn.
	// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Couldn't solve before class


// Your code here along with comments explaining your approach
//recursion
//in recursive function, base case is if node is null return nothing.
//keep adding the nodes in the current list
//else if leaf node reached and sum equals to node.val then add current list as new arraylist to the result "paths" list
//repeat for left and right nodes
//remember to remove stack on end of each recursive call

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, sum, new ArrayList<Integer>(), paths);
        
        return paths;
    }
    
    private void findPaths(TreeNode node, int sum, List<Integer> current, List<List<Integer>> paths){
        if(node == null){
            return;
        }
        
        current.add(node.val);
        if(node.left == null && node.right == null && sum == node.val){
            paths.add(current);
            return;
        }
        
        findPaths(node.left, sum - node.val, new ArrayList<Integer>(current), paths);
        findPaths(node.right, sum - node.val, new ArrayList<Integer>(current), paths);
        
    }
}