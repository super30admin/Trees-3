// S30 Big N Problem #46 {Medium}
// 113. Path Sum II
// Time Complexity :O(n) where n is the number of nodes
// Space Complexity : O(h){asym} where h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> result=new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list=new ArrayList<>();
        dfs(list,root,sum);
        return result;
    }
    private void dfs(List<Integer> list, TreeNode root, int sum){
        if(root==null) return;
        
        sum=sum-root.val;
        list.add(root.val);
        if(sum==0 && root.left==null && root.right==null){// reached the leaf node
            result.add(list);
            return;
        }
        
        dfs(new ArrayList<>(list),root.left, sum);
        dfs(new ArrayList<>(list),root.right,sum);
    }
}