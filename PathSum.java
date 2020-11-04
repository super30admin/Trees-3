// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : nopes.java



// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PathSum {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result=new ArrayList();
        target =sum;


        if(root==null)
            return result;

        helper(root,0,new ArrayList<>());
        return result;


    }
    private void helper(TreeNode root,int currSum,List<Integer> path){

        if(root==null)
            return;

        currSum+=root.val;

        //action
        path.add(root.val);

        if(root.left==null&&root.right==null)
        {

            if(currSum==target)
            {
                System.out.println(path);
                result.add(new ArrayList<>(path));
            }

        }

        //recurse
        helper(root.left,currSum,path);
        helper(root.right,currSum,path);

        //backtrack
        path.remove(path.size()-1);

    }
}