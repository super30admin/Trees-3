//Approach-1: Creating multiple new lists everytime
//Overall Time Complexity: O(N^2) Deepsopies for all the nodes
//Overall Space Complexity: O(NH) At a time a node at max can hold h elements
class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<List<Integer>>();
        helper(root, new ArrayList<Integer>(), 0, targetSum);
        return res;
    }
    
    public void helper(TreeNode node, List<Integer> path, int sum, int target){
        if(node == null) return;
        
        sum += node.val;
        path.add(node.val);
        if(node.left == null && node.right == null && sum == target){
            res.add(path);
        }
        
        helper(node.left, new ArrayList<>(path), sum, target);
        helper(node.right, new ArrayList<>(path), sum, target);
    }
}


//Approach-2: Using Backtracking
//Overall Time Complexity: O(N) - N = Number of nodes in the tree
//Overall Space Complexity: O(H) - H = is the height of the binary tree
//Here we can use either local or global variable for the path
class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<List<Integer>>();
        helper(root, new ArrayList<Integer>(), 0, targetSum);
        return res;
    }
    
    public void helper(TreeNode node, List<Integer> path, int sum, int target){
        if(node == null) return;
        
        sum += node.val;
        path.add(node.val);
        if(node.left == null && node.right == null && sum == target){
            res.add(new ArrayList<>(path));
        }
        
        helper(node.left, path, sum, target);
        helper(node.right, path, sum, target);
        
        path.remove(path.size() - 1);
    }
}