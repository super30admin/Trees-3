//Time Complexity: O(max height * number of leaf nodes)
//Space Complexity: O(height)
/*Approach
-adding the value of each node to a list while calculating the sum,when
we reach leaf node and our sum gets equal to target we will add it to our result
-doing calculation and then going again to left and right subtree
 */
import java.util.ArrayList;
import java.util.List;

public class PathSumII{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }

   List<List<Integer>> result;
   int target;
   public List<List<Integer>> pathSum(TreeNode root, int sum) {
    result = new ArrayList<>();
    target = sum;
    if(root == null) return result;
    helper(root, 0,new ArrayList<>());
    return result;
   }

   public void helper(TreeNode root, int currSum, List<Integer> currList){
       if(root == null) return;
       currSum += root.val;
       currList.add(root.val);
       if(root.left == null && root.right == null && target == currSum){
           result.add(new ArrayList<>(currList));
       }
       helper(root.left, currSum, new ArrayList<>(currList));
       helper(root.right, currSum, new ArrayList<>(currList));

   }

   public static void main(String args[]){
    PathSumII obj = new PathSumII();
    TreeNode root = new TreeNode(5);
    root.left=new TreeNode(3);
    root.left.left= new TreeNode(1);
    root.left.right= new TreeNode(4);
    root.right = new TreeNode(6);
    root.right.left=new TreeNode(1);
    root.right.right=new TreeNode(7);
    System.out.println(obj.pathSum(root, 12));


   }
}