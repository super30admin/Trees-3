// Time Complexity : O(N^2)
// ==> Here we perform deep copy at each leaf.
// In worst case when the tree is Complete Binary tree we have N/2 leafs . So N/2 deep copy operations for N/2 leafs + N/2 Node visits and sum ops
// as a result total TC = O(N^2)

// Space Complexity : O(H) :: No extra space is used Only Auxilliary Stack Space

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    private void pathBuilder(TreeNode root, int targetSum, List<Integer> ds) {

        if (root == null) return;

        // use the root value
        targetSum -= root.val;
        ds.add(root.val);

        // check if its a root node
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                // You got the perfect path Now !
                ans.add(new ArrayList<>(ds));
            }
        }

        // Go left and right
        pathBuilder(root.left, targetSum, ds);
        pathBuilder(root.right, targetSum, ds);

        // BackTracking
        ds.remove(ds.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) return ans;

        pathBuilder(root, targetSum, new ArrayList<Integer>());

        return ans;
    }
}