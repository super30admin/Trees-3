//Using backtracking
//TC is O(n), where n is number of nodes
//SC in O(h^2), where h is height

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
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
class pathSum {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        inorder(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void inorder(TreeNode root, int currSum, int targetSum, List<Integer> path){
        //base
        if(root == null){
            return;
        }
        //logic
        path.add(root.val);
        inorder(root.left, currSum + root.val, targetSum,path);
        if(root.left == null && root.right == null){
            if(currSum + root.val == targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        inorder(root.right, currSum + root.val, targetSum, path);
        path.remove(path.size()-1);
    }
}

