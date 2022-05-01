//Time Complexity : O(n)
//Space Complexity : O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class Solution {
    //class variable for output
    List<List<Integer>> output;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        output=new ArrayList<>();
        //base case 
        if(root ==null)
            return output;
        //call the helper method with local and target sum and a list 
        helper(root, 0, targetSum, new ArrayList<>());
        return output;
    }
    private void helper(TreeNode root, int cSum, int targetSum, List<Integer> path){
        if(root==null)
            return; 
        cSum=cSum+root.val;
        //let it be added to the path
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(cSum==targetSum){
                output.add(path);
            }
        }
        //a new arraylist is created and what ever is in the path is added 
        helper(root.left, cSum, targetSum, new ArrayList<>(path));
        helper(root.right, cSum, targetSum, new ArrayList<>(path));
    }
}