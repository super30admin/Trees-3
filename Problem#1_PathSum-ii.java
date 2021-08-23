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
        List<List<Integer>> answer = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            pathSum(root,sum,new LinkedList<>());
            return answer;
        }
        public void pathSum(TreeNode root,int sum, LinkedList<Integer> result){
            if(root == null) return;
            if(root.left == null && root.right == null){
                if(sum-root.val == 0){
                    result.add(root.val);
                    answer.add(new ArrayList<>(result));
                    result.removeLast();
                    return;
                }
            }
            result.add(root.val);
            pathSum(root.left,sum-root.val,result);
            pathSum(root.right,sum-root.val,result);
            result.removeLast();        
    }
}