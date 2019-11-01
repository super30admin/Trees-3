/** Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
] */

// Time Complexity : O(n) as it traverses and visits each node
// Space Complexity : O(h)?? as we are storing references of addresses. so we keep mutating values in a list as it comes, but we need to one more list to store our actual sum list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach-We will be looking for a path(until leaf node) that will provide sum equal to path-sum(given as 22)
//so we will allocate a list and traverses each node starting from root until it reaches leaf node and simulatenously finding the difference from the target path sum
//once we reach the last node, if it equals the difference, then we can keep that list as it satisfies our path sum
//additionally, we will backtrack if the difference is not equal in the leaf node

class Solution{
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        //this list is for storing final result
        List<List<Integer>> result = new ArrayList<>();
        //this is for storing pathsum once we are traversing each path
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, result, path);
        return result;
    }
    //private access modifier is used for member functions only accessible within the class and not outside
    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path){
        //case 1) if root is null
        if(root == null) return;
        //keep adding root value to path
        path.add(root.val);
        //case 2) left and right are null
        if(root.left == null && root.right == null){
            if(sum == root.val){
                result.add(new ArrayList<>(path));
                return;
            }
        }
        //case 3) if only left child is not rull
        if(root.left != null){
            //pass left child value and find difference from target sum
            dfs(root.left, sum-root.val, result, path);
            //backtracking is done to remove the last node if the difference is not 0 or -ve
            path.remove(path.size() - 1);
        }
        //case 4) if only right child is not null
        if(root.right != null){
            //pass right child value and find the difference from target sum
            dfs(root.right, sum-root.val, result, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}