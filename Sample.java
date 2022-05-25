import java.util.ArrayList;
import java.util.List;

//Path sum 2
//Time Complexity : O(N)
//Space Complexity : O(N)

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
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        if(root == null) return result;
        dfs(root, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int currSum, List<Integer> path){
        //base 
        if(root == null) return;
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(new ArrayList<>(path));
            }
        }
        //logic
        dfs(root.left, currSum, path);
        dfs(root.right, currSum, path);
        //backtrack
        path.remove(path.size() - 1);
  
}
}

//Symmetric Tree
//Time Complexity : O(N)
//Space Complexity : O(N)
class Solution2 {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
         return dfs(root.left,root.right);
   
    }
    public boolean dfs(TreeNode left, TreeNode right) {
    //base
        if(left==null && right==null) return true;
        if(left==null || right==null || left.val!=right.val)return false;
        //logic
        // if left child for left child of a root node and right child of right child of root node and vice versa if they are equal or not
        //if not equal return false
        if(dfs(left.left,right.right)==false)return false;
        return dfs(left.right,right.left);
}
}