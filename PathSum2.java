// TC - O(n), SC - O(n) - stack calls


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
    // Initializing a global result
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // sanity check
        if(root == null){
            return result;
        }
        // Creating a sublist
        List<Integer> subList = new ArrayList<>();
        helper(root, subList, 0, targetSum);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> subList, int curSum, int targetSum){
        // adding the rootval to sublist
        subList.add(root.val);
        // adding root.val to curSum, checking if the current node is leaf node and curSum equals targetSum, then add subList to result.
        curSum += root.val;
        if((root.left == null && root.right == null) && (curSum == targetSum)){
            result.add(new ArrayList<>(subList));
        }
        
        // if root.left not equal to null, call helper method with left node, same with right node
        if(root.left != null){
            helper(root.left, subList, curSum, targetSum);
        }
        
        if(root.right != null){
            helper(root.right, subList, curSum, targetSum);
        }
        // we remove last element from sublist as we reached this stage where we want to find other paths too.
        subList.remove(subList.size() - 1);
        
    }
}


// class Solution {
//     List<List<Integer>> result = new ArrayList<>();
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         if(root == null){
//             return result;
//         }
//         List<Integer> subList = new ArrayList<>();
//         helper(root, subList, targetSum);
//         return result;
//     }
    
//     private void helper(TreeNode root, List<Integer> subList, int remSum){
//         if(root == null){
//             return;
//         }
//         subList.add(root.val);
//         if((root.left == null && root.right == null) && (remSum == root.val)){
//             result.add(new ArrayList<>(subList));
//         }else{
//             helper(root.left, subList, remSum - root.val);
//             helper(root.right, subList, remSum - root.val);
//         }
//         subList.remove(subList.size() - 1);
//     }
// }