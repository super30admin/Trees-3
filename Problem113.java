// Time Complexity : O(n) no.of nodes
// Space Complexity : O(h) stack
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum, ArrayList<Integer> list)
    {
        if(root == null) return ;

        // currSum
        currSum += root.val;
        //action
        list.add(root.val);
        
        if(root.left==null && root.right == null )
        {
            if(currSum == targetSum)
            {
                result.add(new ArrayList<>(list));
             
                
            }
            
            
        }
         // recurse
        helper(root.left, currSum, targetSum, list);
        helper(root.right, currSum, targetSum, list);
         //backtrack
         
            list.remove(list.size()-1);
            
    }

}