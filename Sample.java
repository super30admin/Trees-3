//Path Sum II

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Backtracking Approach
class Solution {

    List<List<Integer>> result;

public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

    result = new ArrayList<>();
    List<Integer> path= new ArrayList<Integer>();
    int number=0;
    helper(root, 0, new ArrayList<>(),targetSum);

    return result;

    }

void helper(TreeNode root, int currSum,List<Integer> path, int targetSum )
{
    //base
    if(root==null)
    return;

    //logic
    currSum+=root.val;
    //action
    path.add(root.val);
    if(root.left==null&&root.right==null) //leaf node
    {
    if(currSum ==targetSum)
    result.add(new ArrayList<>(path));
    }

    helper(root.left,currSum,path,targetSum);
    helper(root.right,currSum,path, targetSum);

    //backtracking 
    path.remove(path.size()-1);
    return;
}
}

// Your code here along with comments explaining your approach



//Symmetric Tree

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
 class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right)
    {
        if(left == null || right == null)
            return left == right;

        if(left.val!=right.val) return false;

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}