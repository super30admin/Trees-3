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
 time complexity : O(n)
 space complexity : Q(h) height of the tree
 */
class Solution {
    List<List<Integer>> pathSums;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSums = new ArrayList<>();
        if(root == null) return pathSums;
        dfs(root,0,new ArrayList<>(),targetSum);
        return pathSums;
    }
    private void dfs(TreeNode root, int sum, List<Integer> list,int target){
        if(root == null) return;
        
        //List<Integer> localList = new ArrayList<>(list);
        list.add(root.val);
        sum += root.val;
        if(root.left ==null && root.right == null ){
            if(sum == target)
                pathSums.add(new ArrayList<>(list));
        }
        dfs(root.left,sum,list,target);
        dfs(root.right,sum,list,target);
        list.remove(list.size() - 1);
    }
}
