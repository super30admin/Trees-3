// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: We use backtracking here. Traverse until the leaf node, calculate the sum, if its equal to the target, add it to the result list. 
//Then we pop the left leaf, traverse to the right, when this is done the left node gets popped from the stack and it counts the sum until right leaf node. This way it will check for all the subtrees


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        this.result=new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int target,int currSum, List<Integer> path)
    {
        //base
        if(root==null) return;
        //logic
        currSum+=root.val;//Add the value of root to the currSum
        path.add(root.val);//Add the value of the root to the inner list

        if(root.left==null && root.right==null)//leaf node
        {
            if(currSum==target)
            {
                result.add(new ArrayList<>(path));
            }
        }
            helper(root.left,target,currSum,path);
            helper(root.right,target,currSum,path);
            path.remove(path.size()-1); //Remove the last element of the path list

    }

}