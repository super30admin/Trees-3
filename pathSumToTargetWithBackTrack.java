package Trees3;
import java.util.ArrayList;
import java.util.List;

/*Source Link: https://leetcode.com/problems/path-sum-ii/
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(n) - n is the number of elements in tree
    space complexity: o(h) - since we are maintaining the same element list with backtracking
    Did this code run successfully in leetcode : yes
    problems faces : no
    */
public class pathSumToTargetWithBackTrack {

    List<List<Integer>> pathSumList = new ArrayList<>();
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int currentSum = 0;
        target = targetSum;
        List<Integer> elementsList = new ArrayList<>();
        inorder(root, elementsList, currentSum);
        return pathSumList;
    }

    public void inorder(TreeNode root, List<Integer> elementsList, int currentSum) {

        if (root == null)
            return;

        currentSum = currentSum + root.val;
        elementsList.add(root.val);

        if (root.left == null && root.right == null && currentSum == target) {
            pathSumList.add(new ArrayList<>(elementsList));

        }

        inorder(root.left,elementsList , currentSum);
        inorder(root.right,elementsList, currentSum);

        //backtrack
        elementsList.remove(elementsList.size()-1);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
