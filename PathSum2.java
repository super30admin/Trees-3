// Time Complexity : O(n)
// Space Complexity : O(h) recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We parse from root to leaf adding value at node. If we are at leaf node and sum = targetsum then we add the path to result.
//If not we remove last ele from path, backtrack one level and add next node until we have found all paths where sum =targetsum

import java.util.ArrayList;
import java.util.List;


//  Definition for a binary tree node.
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        pathSumHelper(path, result, 0, root, targetSum);
        return result;
    }
    private void pathSumHelper(List<Integer> path, List<List<Integer>> result, int currSum, TreeNode root, int targetSum){
        if(root==null){
            return;
        }
        currSum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null && currSum==targetSum){
            result.add(new ArrayList<>(path));
        }
        pathSumHelper(path, result, currSum, root.left, targetSum);
        pathSumHelper(path, result, currSum, root.right,  targetSum);
        path.remove(path.size()-1);
    }
}