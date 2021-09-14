//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode r1 = q.poll();
            TreeNode r2 = q.poll();
            if(r1 == null && r2 == null) {
                continue;
            }
            if(r1 == null || r2 == null) {
                return false;
            }
            if(r1.val != r2.val) {
                return false;
            }
            q.add(r1.left);
            q.add(r2.right);
            q.add(r1.right);
            q.add(r2.left);
        }
        return true;
    }
}