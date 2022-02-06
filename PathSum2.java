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
     int sum=0;
    TreeNode prev;
      List<Integer> ll= new ArrayList<>();
      List<List<Integer>> result= new ArrayList<>();
    //int index= ll.size()-1;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        prev= null;
        
        treeSum(root, 0, targetSum,ll);
        return result;
    }
   
    
     public boolean treeSum(TreeNode root, int num, int target, List<Integer> ll){
         if(root== null) return true;
         ll.add(root.val);
         int index= ll.size()-1;
         System.out.println(index);
         if(root.right==null  && root.left==null){
             if(target==num+root.val){
                 result.add(new ArrayList<>(ll));
             }
         }
            prev=root;
         boolean left= treeSum(root.left, num+root.val, target, ll);
         boolean right = treeSum(root.right, num+root.val, target, ll);
          ll.remove(ll.size()-1);
         return left&& right;
     }
}