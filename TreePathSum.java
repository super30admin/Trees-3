import java.util.*;
class TreePathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
   List<List<Integer>> result = new ArrayList<>();
    public void pathSumHandler(TreeNode root, int sum, int sumSoFar, List<List<Integer>> result, Stack<Integer> path){
        if(root == null) return;
        path.push(root.val); 
        int currSum = sumSoFar + root.val;
        
         if(root.right == null && root.left == null && currSum == sum) {
             result.add(new ArrayList<>(path));
         }
         pathSumHandler(root.left, sum, currSum, result, path);
         pathSumHandler(root.right, sum, currSum, result, path);
         path.pop();
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        pathSumHandler(root, sum, 0, result, path);
        return result;
    }
    public static void main(String[] args){
        System.out.println("TreePathSum");
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        TreePathSum obj = new TreePathSum();
        System.out.println(obj.pathSum(root, 22));
    }
}