/*

Problem1 (https://leetcode.com/problems/path-sum-ii/)

Time Complexity : O(n)
Space Complexity : O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA

 */

 class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        inorder(root, targetSum, 0);
        return res;

    }

    private void inorder(TreeNode root, int target, int sum){

        if(root == null){
            return;
        }

        sum = sum + root.val;
        list.add(root.val);
        if(sum == target && (root.left == null && root.right == null)){
            res.add(new ArrayList(list));
        }

        inorder(root.left, target, sum);
        inorder(root.right, target, sum);
        list.remove(list.size() - 1);

    }
}