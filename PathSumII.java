import java.util.ArrayList;
import java.util.List;

public class PathSumII {


    /*
    TC : O(N^2) where N is the number of nodes in the Trees, we perform the copy operation for the path list while adding to
    the final list which takes O(N) times.
    Therefore in the worst case, we have N/2 leaf nodes, and for each leaf node we take O(N) time for copying.
    Hence the time taken is O(N^2)
    SC : O(H) where H = logN is the height of the tree
     */

    /*
    The approach here is similar to the sum root To leaf problem. Just that we also maintain a local path at each step and
   after the recursive calls to the left and right child of the node is done, we remove the node from the path.
   This allows us to use a single path varaible and not use a lot of space
     */
    public List<List<Integer>> result = new ArrayList<>();
    public int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        helper(root, 0, new ArrayList<>());
        return result;
    }

    public void helper_inorder_recursive(TreeNode root, int currSum, List<Integer> path) {


        if (root == null)
            return;


        currSum += root.val;
        path.add(root.val);

        helper(root.left, currSum, path);

        if (root.left == null && root.right == null) {

            if (currSum == target)
                result.add(new ArrayList<>(path));
        }

        helper(root.right, currSum, path);
        path.remove(path.size() - 1);

    }

    public void helper_preorder_recursive(TreeNode root, int currSum, List<Integer> path) {


        if (root == null)
            return;


        currSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {

            if (currSum == target)
                result.add(new ArrayList<>(path));
        }

        helper(root.left, currSum, path);
        helper(root.right, currSum, path);
        path.remove(path.size() - 1);

    }

    public void helper_postorder_recursive(TreeNode root, int currSum, List<Integer> path) {


        if (root == null)
            return;


        currSum += root.val;
        path.add(root.val);

        helper(root.left, currSum, path);

        helper(root.right, currSum, path);
        if (root.left == null && root.right == null) {

            if (currSum == target)
                result.add(new ArrayList<>(path));
        }
        path.remove(path.size() - 1);

    }


}
