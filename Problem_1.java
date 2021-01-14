// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//I keep on inserting the value for the node at every recursive cal.
//As the arraylist is passed by reference so i am also removing the lat element from the arraylist.

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<>();
        if(root ==null) return list;
        List<Integer> li=new ArrayList<>();
        helper(list,root,0,sum,li);
        return list;
    }
    
    public void helper(List<List<Integer>> list,TreeNode root,int run,int sum,List<Integer> li){
        if(root ==null){
            return;
        }
        if(root.left==null && root.right==null){
            if((run+root.val)==sum){
                //System.out.println(root.val);
                li.add(root.val);
                //System.out.println(li);
                list.add(new ArrayList<>(li));
                //System.out.println(list);
                li.remove(li.size()-1);
            }
            
            return;
        }
        li.add(root.val);
        helper(list,root.left,run+root.val,sum,li);
        helper(list,root.right,run+root.val,sum,li);
        li.remove(li.size()-1);
    }
}