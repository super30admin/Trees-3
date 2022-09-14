
// Brute Force   
public class PathSumII {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root,0,new ArrayList<>(),targetSum);
        return result;
    }
    private void helper(TreeNode root, int curSum,List<Integer> path, int targetSum){
        if(root==null) return;
        
        curSum+=root.val;
        List<Integer> temp = new ArrayList<>(path);
        temp.add(root.val);
        //check for leaf node
        if(root.left==null && root.right==null){
            if(curSum==targetSum) result.add(temp);
        }
        helper(root.left,curSum,temp,targetSum);
        helper(root.right,curSum,temp,targetSum);
    }
}

// Time Complexity - O(n) [ worstcase - O(n2) - skewed tree]
// Space Complexity - O(n*h) [worstcase - O(n2)]


// Optimized - Backtracking solution
public class PathSumIIOptimized {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(root,0,targetSum);
        return result;
    }
    private void helper(TreeNode root, int curSum, int targetSum){
        if(root==null) return;
        curSum+=root.val;
        
        // Action
        path.add(root.val);
        //check for leaf node
        if(root.left==null && root.right==null){
            if(curSum==targetSum) result.add(new ArrayList<>(path));
        }
        
        //Recursion
        helper(root.left,curSum,targetSum);
        helper(root.right,curSum,targetSum);
        
        //backtracking
        path.remove(path.size()-1);
    }
}

// Time Complexity - O(n) [Because there is no deep copy at all nodes]
// Space Complexity - O(h) [worstcase - O(n)]