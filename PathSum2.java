// Time Complexity :  O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<List<Integer>>();
        helper(root, sum, 0 ,res, new ArrayList<>());
        return res;
    }
    public void helper(TreeNode root, int sum, int tempSum, List<List<Integer>> res, List<Integer> temp){
        //base
        if(root == null) return;
        tempSum += root.val;
        temp.add(root.val);
        if( root.left == null && root.right == null){
            if(tempSum == sum)
                // System.out.println(temp);
                res.add(new ArrayList<>(temp));
        }
        
        
        //logic
        helper(root.left, sum, tempSum , res, temp); 
        helper(root.right, sum, tempSum , res, temp);
        temp.remove(temp.size()-1);
        
    }
}