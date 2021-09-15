import java.util.*;
public class TreeSolution {
    // Time Complexity : N
// Space Complexity : H (H= height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
    static List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        helper(root,targetSum,path,0);
        return result;
    }

    private static void helper(TreeNode root,int sum,List<Integer> path,int targetSum){
            if(root == null){
                return;
            }
            sum = sum + root.val;
            path.add(root.val);
            if(root.left == null && root.right == null){
                if(sum == targetSum){
                    result.add(new ArrayList(path));
                }
            }
            
            helper(root.left,sum,path,targetSum);
            helper(root.right,sum,path,targetSum);
            path.remove(path.size()-1);
    }

    // Time Complexity : N
// Space Complexity : H (H= height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
    //https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return helper(root.left,root.right);    
    }
    private static boolean helper(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        
        if(left== null || right == null) return false;
        if(left.val != right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
