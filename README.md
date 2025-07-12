# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We will create a list and  add the nodes to the list where we will find that the sum of all the elements from the root to leaf is equal to the target
2. the temp list will be added to an ans list of lists 
3. Everytime we will add a new list instead of the same temp list as the reference of the list will be passed and if we will further modify that list it will also affect the list added in the ans list

class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        recurse(root, 0, targetSum, new ArrayList<>());
        return ans;
    }

    private void recurse(TreeNode root, int currSum, int targetSum, List<Integer> path){
        if(root == null) return;

        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && currSum == targetSum){
            ans.add(new ArrayList<>(path)); 
        }

        recurse(root.left, currSum, targetSum, path);
        recurse(root.right, currSum, targetSum, path);

        path.remove(path.size() - 1); 
    }
}

## Problem2 (https://leetcode.com/problems/symmetric-tree/)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We can see that the left child of the left subtree must be equal to right child of the right subtree 
2. Also the right child value of the left tree must be equal to left child of the right tree
3. we will go for dfs and check if their value are same or both of them are null if ot is so we will return true else false
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null || left.val != right.val){
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}