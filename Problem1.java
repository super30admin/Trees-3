public class Problem1 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
//    TC : O(n)
//    Sc : O(h) where h = height of tree

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<Integer>());
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum, ArrayList<Integer> pathSum) {
        if (root == null) return;

        currSum = currSum + root.val;
        //action
        pathSum.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                System.out.println("result value" + pathSum);
                result.add(new ArrayList<>(pathSum));
                System.out.println("*****");
            }
        }

        //recurse
        helper(root.left, currSum, targetSum, pathSum);
        helper(root.right, currSum, targetSum, pathSum);
        //backtrack
        System.out.println("before doing backtrack " + pathSum);
        pathSum.remove(pathSum.size() - 1);
        System.out.println("after doing backtrack " + pathSum);

    }
}
