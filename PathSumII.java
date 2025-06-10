// Time Complexity :O(L*H)
// Space Complexity :O(L*H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : o
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root,targetSum,0,path,result);

        return result; 
    }

    private void helper(TreeNode root, int targetSum, int currSum,List<Integer> path, List<List<Integer>> result){

        //base
        if(root==null) return;
        //logic
        
        currSum+=root.val;
        path.add(root.val);
        
        helper(root.left,targetSum,currSum, path, result);
        
        helper(root.right,targetSum,currSum, path, result);
        if(root.left==null && root.right==null){
            if(currSum==targetSum)
                result.add(new ArrayList<>(path));
        }
        //backtrack
        path.remove(path.size()-1);
    }
}