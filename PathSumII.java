// Time Complexity :O(n) n is the number of nodes is the tree and time if for recursive call on every node (we make a deep copy of prev list only at every leaf node)
// Space Complexity :O(h)  where h is the height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 2 - Back Tracking
//TC: O(n) n is the number of nodes is the tree and time if for recursive call on every node (we make a deep copy of prev list only at every leaf node)
//SC: O(h)  where h is the height of tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root,0,new ArrayList<>(),targetSum);
        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path, int target){
        //base case
        if(root == null)
            return;

        //logic
        currSum += root.val;

        //action
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }

        //recurse
        helper(root.left,currSum,path,target);
        helper(root.right,currSum,path,target);

        //backtrack
        path.remove(path.size()-1);
    }
}
/*
//Method 1 - Recursion
TC: O(n^2) for every recursive call, we make a deep copy of prev list
SC: O(n*h) for every node, we have to create a list. So number of nodes n * height of tree

public class PathSumII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
/*
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();
            helper(root,0,new ArrayList<>(),targetSum);
            return result;
        }

        private void helper(TreeNode root, int currSum, List<Integer> path, int target){
            //base case
            if(root == null)
                return;

            //logic
            currSum += root.val;
            path.add(root.val);

            if(root.left == null && root.right == null){
                if(currSum == target){
                    result.add(path);
                }
            }

            helper(root.left,currSum,new ArrayList<>(path),target);
            helper(root.right,currSum,new ArrayList<>(path),target);
        }
    }
}
*/