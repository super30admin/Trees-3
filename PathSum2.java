// Time Complexity : O(n^2)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Use DFS traversal to explore all paths from root to leaf.
// Keep track of the current path and current sum along the way.
// At each leaf node, check if the sum equals targetSum.
// If it does, add the current path (make a copy) to the result list.




import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    List<List<Integer>> res;
    public List<List<Integer>> solve(TreeNode root, int targetSum){
        if(root == null){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>());
        return res;

    }

    private void dfs(TreeNode root, int currSum, int targetSum, List<Integer> path){
        //base
        if(root==null) return;

        currSum = currSum + root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        dfs(root.left, currSum, targetSum, new ArrayList<>(path));
        dfs(root.right, currSum, targetSum, new ArrayList<>(path));
    }

    public static void main(String[]args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        PathSum2 ob = new PathSum2();
        List<List<Integer>> res = ob.solve(root, targetSum);

        System.out.println("Paths that sum to " + targetSum + ":");
        for (List<Integer> path : res) {
        System.out.println(path);
    }

    }
    
}
