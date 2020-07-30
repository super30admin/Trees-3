// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        result=new ArrayList<>();
        target=sum;
        
        List<Integer> path=new ArrayList<>();
        
        helper(root,0,path);
        
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path)
    {
        if(root==null) return;
        
        /* Action */
        
        /* Check if its a leaf node */
        path.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(currSum+root.val==target)
                result.add(new ArrayList<>(path));
        }
        
        /* Recurse */
        
        helper(root.left,currSum+root.val,path);
        helper(root.right,currSum+root.val,path);
        
        /* Backtrack */
            
        path.remove(path.size()-1);
    }
}