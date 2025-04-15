import java.util.ArrayList;
import java.util.List;
// Time Complexity : O(n)
// Space Complexity :O(h) + O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
This program identifies all root-to-leaf paths in a binary tree where the sum of the node values matches
 a given target. It keeps track of the current path and cumulative sum while traversing the tree.
 When a leaf node is reached and the sum equals the target, the current path is added to the result list.
  After exploring a path, it removes the last node to correctly backtrack and explore other possibilities.
The approach ensures all valid paths are found efficiently using recursion and backtracking.



*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class PathSumII {
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList<>();

        helper(root,targetSum,0,new ArrayList<>());

        return ans;
    }

    private void helper(TreeNode root,int targetSum,int currSum,List<Integer> temp)
    {
        if(root==null)
            return;
        //action
        temp.add(root.val);
        currSum+=root.val;
        if(root.left==null && root.right==null)
        {
            if(currSum==targetSum)
                ans.add(new ArrayList<>(temp));
        }
        //recurse
        helper(root.left,targetSum,currSum,temp);
        helper(root.right,targetSum,currSum,temp);


        //backtrack

        temp.remove(temp.size() - 1);
    }
}
