/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {

            TreeNode left = queue.remove();
            TreeNode right = queue.remove();

            if(left == null && right == null) {
                continue;
            }

            if(left == null || right == null) {
                return false;
            }

            if(left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result;
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;

        result = new ArrayList<>();

        // Temporary list to store the current path during recursion
        List<Integer> list = new ArrayList<>();

        // Start the recursive helper function to process the tree from the root
        helper(root,0,list);

        // Return the list of paths that sum up to targetSum
        return result;
    }

    // Helper function to explore all paths recursively
    public void helper(TreeNode node, int curSum, List<Integer> curList){

        // Base case: If the current node is null, return (no further path)
        if(node == null) {
            return;
        }

        // Action - Add the current node's value to the running sum and path
        curSum = curSum + node.val; // Update the running sum

        curList.add(node.val); // Add current node's value

        // Check if the current node is a leaf and if the sum matches the targetSum
        if(node.left == null && node.right == null && curSum == targetSum){

            // If it is a valid path, make a copy of the current path and add to result
            List<Integer> tempRes = new ArrayList<>(curList);

            result.add(tempRes);
        }

        //recurse
        helper(node.left,curSum,curList);

        //recurse right
        helper(node.right,curSum,curList);

        // Backtrack: Remove the current node from the path before going back up the tree
        curList.remove(curList.size()-1);
    }
}