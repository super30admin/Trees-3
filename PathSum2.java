// Time Complexity : O(n)
// Space Complexity : O(h) : h--> height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach1: Recursive solution(DFS)
// In this approach, I am calculating the sum on each node traversal. If the sum matches, I am adding the list formed until this step into my result list.
// This approach is not very efficient because for each path I am creating a new temporary list. My space complexity will be large as my recursive stack will hold a new auxiliary list datastructure for each new node traversed.

// Optimized approach:
// Instead of creating new auxiliary list for each path, we can reuse same list by resetting it. We can remove the last element while backtracking. When the sum matches the target, a new list can be created by copying existing list in a new arraylist.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if(root == null) return result;
        target = sum;
        dfs(root, 0, new ArrayList<>());
        return result;
    }
    
    private void dfs(TreeNode root, int currSum, List<Integer> list) {
        // base case
        if(root == null) return;
        currSum += root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && currSum == target) 
            //result.add(list);
            result.add(new ArrayList<>(list));
        
        //Logic
        // dfs(root.left, currSum, new ArrayList<>(list));
        // dfs(root.right, currSum, new ArrayList<>(list));
        dfs(root.left, currSum, list);
        dfs(root.right, currSum, list);
        
        list.remove(list.size()-1);
    }
}

