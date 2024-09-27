// Time Complexity :O(N)
// Space Complexity :Recursion stack + O(H)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null ) return new ArrayList();
        
        List<Integer> curPath = new ArrayList();
        List<List<Integer>> output = new ArrayList();
        
        helper(root, sum, 0, curPath, output);
        
        return output;
    }
    
    private void helper(TreeNode root, int target, int curSum, 
    List<Integer> curPath,List<List<Integer>> output){
        if(root == null) return ;
        
        if(root.left == null && root.right == null){
            if(curSum + root.val == target ){
                List<Integer> temp = new ArrayList(curPath);
                temp.add(root.val);
                output.add(temp);
            }
        }
        curPath.add(root.val);
        
        helper(root.left, target, curSum+root.val, curPath, output);
        helper(root.right, target, curSum+root.val, curPath, output);
        
        curPath.remove(curPath.size()-1);
    }
}
