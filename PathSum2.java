//The approach here is to keep track of a path arraylist that adds the value of a node when traversing and upon reaching a leaf node, we check if the target sum equals the current sum
//If they are equal, then we add a copy of the path till that point to a new arraylist and add it to the result.
//If they are not equal, then when going upwards and before traversing to the next node, we remove the last added node value from the path, thus one path list would be enough while traversing
//Time Complexity: O(n)
//Space Complexity: O(h) where h is the maximum depth of a tree from root to a leaf node
import java.util.ArrayList;
import java.util.List;

class TreeNode {
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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, new ArrayList<>(), 0, targetSum);
        return result;        
    }

    private void helper(TreeNode root, List<Integer> path, int currSum, int targetSum){
        //base
        if(root == null) return;
        currSum+=root.val;
        //action
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path)); // creating a deep copy when at leaf node and when currsum equals targetsum and then add that to the result
            }
        }
        //recurse
        helper(root.left, path, currSum, targetSum);
        helper(root.right, path, currSum, targetSum);
        //backtrack
        path.remove(path.size()-1);
    }
}
