import java.util.ArrayList;
import java.util.List;


//Time Complexity : O(nlogn)   (height = logn)
//Space Complexity : O(logn)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
 /*

/*
We recursively traverse in preorder way go through all nodes till the child and also add the node values in list and in a variable.
 If node is child node then we check the total value is equal as target or not. If equals we add the list into result list.
 We are doing here pass by reference, so we need to create new list while storing result. We go on removing nodes as we reach a child node.
 */ 
class PathSumTwo {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        helper(root, new ArrayList<>(),0,targetSum);
        return res;
    }
    private void helper(TreeNode root, List<Integer> ll,int curr, int target){
        if(root==null){
            return;
        }

        //logic
        ll.add(root.val);
        curr=curr+root.val;
        if(root.left==null && root.right==null && curr==target){
            res.add(new ArrayList<>(ll));
        }
        helper(root.left,ll,curr,target);
        helper(root.right,ll,curr,target);
        ll.remove(ll.size()-1);

    }
}
