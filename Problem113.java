package problems.tree;

import java.util.ArrayList;
import java.util.List;
//TC=O(n)
//SC=O(h) where h is height of tree
public class Problem113 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result=new ArrayList<>();
        backtrack(root, 0,targetSum,new ArrayList<>());
        return result;
    }

    private void backtrack(TreeNode root, int currSum, int targetSum, ArrayList<Integer> path){
        //base condition
        if(root==null)
            return;
        //logic
        currSum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum==targetSum)
                result.add(new ArrayList<>(path));
        }
        //recursion
        backtrack(root.left,currSum,targetSum,path);
        backtrack(root.right,currSum,targetSum,path);
        //backtrack
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        Problem113 problem=new Problem113();
        System.out.println(problem.pathSum(root,22));

    }
}
