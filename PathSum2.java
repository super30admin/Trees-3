
// Time Complexity :O(n) where n is the number of nodes
// Space Complexity : O(log n) in the best case scenario and O(n) in the worst cases
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
import java.util.ArrayList;
import java.util.List;

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
class PathSum2 {
    List<List<Integer>> resultList;
    List<Integer> pathList;
    int prevSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathList = new ArrayList<>();
        resultList = new ArrayList<List<Integer>>();

        preOrderTraversal(root, targetSum);
        return resultList;
    }

    private void preOrderTraversal(TreeNode root, int targetSum){
        if(root == null) return;
        if(root.left == null && root.right == null){
            int pathSum = prevSum + root.val;
            if(pathSum == targetSum){
                List<Integer> tempList = new ArrayList<>(pathList);
                tempList.add(Integer.valueOf(root.val));
                resultList.add(tempList);
            }
            return;
        }
        //root
        prevSum = prevSum + root.val;
        pathList.add(root.val);

        if(root.left != null){
            preOrderTraversal(root.left, targetSum);
        }

        if(root.right != null){
            preOrderTraversal(root.right, targetSum);
        }

        //remove the last element
        pathList.remove(pathList.size()-1);
        prevSum = prevSum - root.val;
    }

}