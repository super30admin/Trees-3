import java.util.ArrayList;
import java.util.List;
//tc = o(n^2) n for visiting each node,n for copying operation of list while creating new
// sc = o(n) recursion  
class TreeNode {
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
 
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    private void helper(TreeNode root,int targetSum,int current,ArrayList<Integer> path){
        if(root == null)return;
        current += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == current){
                result.add(new ArrayList<Integer>(path));
            }
        }
        helper(root.left,targetSum,current,path);
        helper(root.right,targetSum,current,path);
        path.remove(path.size() -1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> path = new ArrayList<>();
        helper(root,targetSum,0,path);
        return result;
    }
}