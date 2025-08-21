// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// curSum saves the sum of the path from root to the node and path saves the path taken so far. If the node is a leaf and curSum is targetsum, new copy the path as a new array into the result. We need to backtrack once we leave the node because we are passing the list by reference.

class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        helper(root, 0, targetSum, new ArrayList());
        return result;
    }

    private void helper(TreeNode root, int curSum,int targetSum, List<Integer> path){
        
        if(root == null) return;

        curSum += root.val;
        path.add(root.val);
        // System.out.println(path);
        if(root.left == null && root.right==null){
            if(curSum == targetSum){
                result.add(new ArrayList<>(path));
            }
            path.removeLast();
            return;
        }

        helper(root.left,curSum,targetSum,path);
        helper(root.right,curSum,targetSum,path);

        path.removeLast();
        return;
    }
}