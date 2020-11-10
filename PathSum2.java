/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Idea is to use recusion, code comments contains explanation.
 * 
 * Time Complexity: O(n)
 * Space Compexity: O(n), worst case
 * 
 * Leetcode result:
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
 * Memory Usage: 38.2 MB, less than 100.00% of Java online submissions for Path Sum II.
 */
class Solution {
    /**
     *
     * @param root reference to root node of the given tree
     * @param sum target that needs to be achieved
     * @return lists of path from root to leaf whose sum equals given sum
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> stack = new LinkedList<>(); // to store the trace
        List<List<Integer>> result = new LinkedList<>();
        pathSumHelper(result, root, 0, sum, stack);
        return result;
    }
    
    /**
     * 
     * @param result lists of path from original root to leaf whose sum equals target
     * @param root current node 
     * @param currentSum sum until this node
     * @param target sum to be achieved
     * @param stack contains the trace of elements
     */
    private void pathSumHelper(List<List<Integer>> result, TreeNode root, int currentSum, int target, LinkedList<Integer> stack) {
        // base case
        if(root == null) {
            return;
        }
        // if this is leaf node, check if the path meets the requirements.
        if(root.left == null && root.right == null) {
            if(currentSum + root.val == target) {
                stack.add(root.val);
                List<Integer> trace = new LinkedList<>();
                for(int element : stack) {
                    trace.add(element);
                }
                result.add(trace);
                stack.removeLast();
            }
            return;
        }
        // recurse on the left subtree
        if(root.left != null) {
            stack.add(root.val);
            pathSumHelper(result, root.left, currentSum + root.val, target, stack);
            stack.removeLast();
        }
        // recurse on the right subtree 
        if(root.right != null) {
            stack.add(root.val);
            pathSumHelper(result, root.right, currentSum + root.val, target, stack);
            stack.removeLast();
        }
        
    }
}