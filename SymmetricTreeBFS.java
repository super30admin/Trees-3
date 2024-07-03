// Time Complexity : O(n) => We are visiting n nodes
// Space Complexity : O(n) => We are storing elements in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot to add continue if both the elements are null

/*
Approach: Using BFS. In the queue, start by adding the root's left and right child. Then calculate size of the queue and pop both the elements and check if both are null continue, if either is null return false, if values are different then return false. Othwerise, simply add right and left child
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr1 = q.poll();
                TreeNode curr2 = q.poll();

                if (curr1 == null && curr2 == null) {
                    continue;
                }

                if (curr1 == null || curr2 == null) {
                    return false;
                }

                if (curr1.val != curr2.val) {
                    return false;
                }

                q.add(curr1.left);
                q.add(curr2.right);
                q.add(curr1.right);
                q.add(curr2.left);
            }
        }

        return true;
    }
}