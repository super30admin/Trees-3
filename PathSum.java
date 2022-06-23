// Time Complexity : O(n) n is total no of nodes in tree
// Space Complexity : O(h) h is the height of the tree, space of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int target = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        target = targetSum;
        if(root!=null){
            helper(root, list, 0);
        }
        return result;
    }

    public void helper(TreeNode root, List<Integer> list, int sum){
        sum+=root.val;
        List<Integer> li = new ArrayList<>(list);
        li.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==target){
                result.add(li);
            }
        }
        else{
            if(root.left!=null){
                helper(root.left, li, sum);
            }
            if(root.right!=null){
                helper(root.right, li, sum);
            }
        }
    }
}