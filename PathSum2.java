//Time Complexity- O(n^2)
//Space Complexity- O(n^2)
//Successfully ran on leetcode

class Solution {
 List<List<Integer>> result;
 int target;
 public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     
     result = new ArrayList<>();
     target= targetSum;
     
     if(root==null) return result;
     
     helper(root,0, new ArrayList<>());
     
     return result;
     
 }
 private void helper(TreeNode root, int sum, List<Integer> path){
     
     //base
     if(root== null) return;
     //logic
     path.add(root.val);
     sum = sum+ root.val;
     
     if(root.left == null && root.right == null){
         if(sum == target){
         result.add(path);
         }
         return;
     }
     helper(root.left, sum, new ArrayList(path));
     helper(root.right, sum, new ArrayList(path));
     
 }
}