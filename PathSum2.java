// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the tree, space used in the recursive stack, under the hood
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Recurse to the left of the tree and then to the right of the tree while calulating the current sum at each node and the list with the path to that node, until we reach at the leaf of the tree where the current sum equals the target sum. Once the leaf is found add the list with the path to the result, and then move to the right sub-tree. After this, remove the element that was added to the list, for backtracking. 

public class PathSum2 {
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        result = new ArrayList<>();
        
        if(root == null ) return result;
        
        List<Integer> path = new ArrayList<>();
        
        backtrack(root, 0, sum, path);       
        return result;
    }
    
    private void backtrack(TreeNode root, int currentSum, int targetSum, List<Integer> path){
        
        if(root == null) return;
        
        currentSum = currentSum + root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null && currentSum == targetSum){
            result.add(new ArrayList<>(path));
        }
        
        backtrack(root.left, currentSum , targetSum, path);
        backtrack(root.right, currentSum , targetSum, path);
        
        path.remove(path.size() - 1);
    }
}
