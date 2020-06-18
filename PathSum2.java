/**
 * Time Complexity : O(n^2) where n = number of nodes
 * Space Complexity : O(n)
 */

 import java.util.*;
public class PathSum2{
    public List<List<Integer>> result;
        int target;
        public List<List<Integer>> pathSum(TreeNode root, int sum){
            result = new ArrayList<>();
            target = sum;
            if(root == null) return result;
            helper(root,0,new ArrayList<>());
            return result;
            
        }
        
        private void helper(TreeNode root, int CurrSum, List<Integer> temp){
            // base case
            if(root == null) return;
            //logic
            CurrSum+=root.val;
            temp.add(root.val); //action
            if(root.left==null && root.right == null){
                if(CurrSum == target){
                    result.add(new ArrayList<>(temp));
                }
            }
            //recurse
            helper(root.left,CurrSum,new ArrayList<>(temp));
            helper(root.right,CurrSum,new ArrayList<>(temp));
            //backtrack
            temp.remove(temp.size()-1);
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
             }
}