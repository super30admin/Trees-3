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
class Solution {
            List<List<Integer>> result;
 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root,new ArrayList<>(),0,targetSum );
        return result;
    }


    private  void helper(TreeNode root,List<Integer> path, int currSum,int target){
        //base
        if(root == null) return;
        //logic
        currSum+=root.val;
       //action
       path.add(root.val);
        if(root.left == null && root.right== null){
            if(currSum==target){
                result.add(new ArrayList<>(path));
            }
             
          // return;
        }
        //recurse
        helper(root.left,path,currSum,target);
        helper(root.right,path,currSum,target);
        //backtrack
        path.remove(path.size()-1);


    }

    }
