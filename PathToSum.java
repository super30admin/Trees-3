import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) n is the number of nodes
// Space Complexity : O(n) + O(h)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :N


public class PathToSum {
    List<List<Integer>> result;
    List<Integer> path;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        this.path= new ArrayList<>();
        this.result = new ArrayList<>();
        helper(root,0);
        return result;
    }

    public void helper(TreeNode root, int currSum)
    {

        if(root == null)
            return;

       currSum = currSum + root.val;
       path.add(root.val);
       if(root.left == null && root.right == null )
       {
           if(currSum == target)
           {
               result.add(new ArrayList<>(path));
           }
       } 
        helper(root.left,currSum);
        helper(root.right,currSum);

        //backtrack
        path.remove(path.size()-1);
    }

    public static void main(String [] args)
    {
        PathToSum bst = new PathToSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        // Function call
        System.out.println(bst.pathSum(root, 22).toString());
    }
}
