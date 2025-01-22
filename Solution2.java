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
class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        DFS(root, targetSum, new ArrayList<Integer>());
        return res;
    }

    public void DFS(TreeNode node, int targetSum, List<Integer> list){
        if (node == null){
            return;
        }
        targetSum = targetSum - node.val;
        list.add(node.val);
        if(node.left == null && node.right == null && targetSum == 0){
            res.add(new ArrayList<>(list));
        }
        else{
                DFS(node.left,targetSum, list);
                DFS(node.right,targetSum, list);
        }
        list.remove(list.size() - 1);
    }
}