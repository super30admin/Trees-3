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
    //Time complexity: O(n)
    //Space complexity: O(n)
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res=new ArrayList<>();
        if(root==null)
            return res;
        inorder(root,0,new ArrayList<>(),targetSum);
        return res;
    }
    private void inorder(TreeNode root,int currSum,List<Integer> path,int targetSum){
        if(root==null)
            return;
        currSum+=root.val;
        path.add(root.val);
        inorder(root.left,currSum,path,targetSum);
        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                res.add(new ArrayList<>(path));
            }
            
        }
        inorder(root.right,currSum,path,targetSum);
        path.remove(path.size()-1);
    }
}