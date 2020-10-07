// Time Complexity : O(N) - N is number of nodes in the tree
// Space Complexity : O(N) - As we used a additional data structure (ArrayList) as well as program stack occupies O(N) space due to function calls
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

 /*Used a ArrayList to store the elements and calculated the sum of each path.
 If sum is  equal to the target value given add the particular path to the main nested arraylist*/
class Solution {
    List<List<Integer>> arr1 = new ArrayList<>();
    int target = 0;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.target = sum;
        ArrayList<Integer> arr2 = new ArrayList<>();
        helper(root,sum,arr2);
        return arr1;
    }
    public void helper(TreeNode root,int currsum,ArrayList arr2){
        if(root == null) return;
        arr2.add(root.val);
         if(root.left == null && root.right == null){
             if(currsum  == root.val){
                 arr1.add(new ArrayList<Integer>(arr2)); 
              }
          }
        
          helper(root.left,currsum - root.val,arr2);
          helper(root.right,currsum - root.val,arr2);
          arr2.remove(arr2.size() - 1);
        }
    }
  

// Your code here along with comments explaining your approach