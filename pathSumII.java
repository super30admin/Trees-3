// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

public class pathSumII {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        target=targetSum;
        helper(root,0, new ArrayList<>());
        return result;
        
    }
    
    public void helper(TreeNode root, int currSum, List<Integer> path){
        if(root==null)
            return ;
        
        currSum+=root.val;
        path.add(root.val);
        
        if(root.left==null && root.right==null){
            if(currSum==target){
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.left, currSum,path);
        helper(root.right, currSum,path);
        path.remove(path.size()-1);
    }
    
}
