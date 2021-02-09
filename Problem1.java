// Time Complexity :O(n)
// Space Complexity :O(depth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


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
class Solution {
    List<List<Integer>> out;//global list 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        out= new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<>();
  
        calc(root,targetSum,list);
        return out;
    }
    public void calc(TreeNode root, int target, List<Integer> list)
    {
        if(root==null)
            return;
        
        list.add(root.val);
        if(root.left==null && root.right==null && root.val==target)//if it is leaf node and our target is same as root.val we add the list iterated so far to out.
        {
            //System.out.println("target achieved"+curr+"last element is :"+ list.get(list.size()-1));
            out.add(new LinkedList(list));
            list.remove(list.size()-1);//removinf since we already found the list we don't need the last element
            return;
        }
        
        
        calc(root.left,target-root.val,list);
        calc(root.right,target-root.val,list);
        list.remove(list.size()-1);//removing in case of not found and we are leaf.
        
        
    }
}