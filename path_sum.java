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
    int cur_sum;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       cur_sum = 0; 
        result = new LinkedList<>();
        if(root == null){
            return result;
        }
        
        dfs(root, targetSum, new LinkedList<Integer>());
        return result;
    }
    
    public void dfs(TreeNode root, int target, List<Integer> sum_list){
        
        cur_sum += root.val;
        sum_list.add(root.val);
        if(root.left == null && root.right == null){
            if(cur_sum == target){
                
                result.add(new LinkedList<>(sum_list));
                sum_list.remove(sum_list.size() - 1);
                cur_sum -= root.val;
                return;
            }
        }

        if(root.left != null){
            dfs(root.left, target, sum_list);
        }

        if(root.right != null){
            dfs(root.right, target, sum_list);
        }

        sum_list.remove(sum_list.size() - 1);
        cur_sum -= root.val;
        
    }
}