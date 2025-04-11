// Time Complexity : O(N)
// Space Complexity : O(N/2)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        // we do not need to add root
        q.add(root.left);
        q.add(root.right);

        // we do not need the size variable.. just get the adjacent one
        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            // we do not need to check null here as we need to add those values to queue too
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
