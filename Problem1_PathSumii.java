import java.util.ArrayList;
import java.util.List;

// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
     List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new  ArrayList<List<Integer>>();
               
          helper(root,targetSum,0,new ArrayList<Integer>());
        
        return result;
    }
    
    private void helper(TreeNode root, int targetSum,int currSum ,List<Integer> temp)
    {
        if(root==null)
            return;
        currSum+=root.val;
        temp.add(root.val);
       //helper(root.left,targetSum,currSum,new ArrayList<>(temp)); // one way is to create new list for every call coz if we dont create all node which are visisted at every call recursive will be added to list so we are new list of that path nodes every time so we will have only path nodes
        helper(root.left,targetSum,currSum,temp); // other way is just create new arraylist when currsum is targetsum then add to result list
        if(root.left==null && root.right==null && targetSum==currSum)
        {
            result.add(new ArrayList<>(temp));
        }
       helper(root.right,targetSum,currSum,temp);
        //after this we will go to previous node recursion so remove leaf node from list so it can go to right or previous nodes
        temp.remove(temp.size()-1);
        
    }
}
