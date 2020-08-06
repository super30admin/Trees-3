// Time Complexity : O(N^2) N is number of nodes in the tree, for each node, we are copying array which could be N in worst case
// Space Complexity : O(N.h), for each node in a path we are keeping a copy array and there could be maximum nodes in the path same as the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// We have to traverse from root to leaf node and add up the values in the nodes. I will keep the path from root to leaf in list
// and if at the root node, the total sum is equal to target, then I will add that valid path to the result. If at the leaf node,
// the sum is not equal to target sum, we don't add that node to the path.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<Integer> queue = new LinkedList<>();
        getPaths(root, result, queue, sum, 0);

        return result;
    }

    private void getPaths(TreeNode root, List<List<Integer>> result, LinkedList<Integer> queue, int sum, int currSum) {
        if (root == null) return;

        currSum += root.val;
        queue.add(root.val);
        if (root.right == null && root.left == null) {
            if (currSum == sum) {
                result.add(queue);
                return;
            }
        }
        // do not pass the reference, create a copy of the queue
        getPaths(root.left, result, new LinkedList<>(queue), sum, currSum);
        getPaths(root.right, result, new LinkedList<>(queue), sum, currSum);
    }
}
