// https://leetcode.com/problems/symmetric-tree/

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use a BFS queue
// Add to queue and compare (left's right with right's left) &
// (left's left with right's right), at any point if not equal
// tree is asymmetric

class Solution {
    // Modified BFS
    // T: O(N)
    // S: O(N)
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(root);

        while(!q.isEmpty()){
            TreeNode l = q.poll();
            TreeNode r = q.poll();

            if(l.val!=r.val){
                return false;
            }

            if(l.left!=null && r.right!=null){
                q.add(l.left);
                q.add(r.right);
            }
            if((l.left==null && r.right!=null) || (l.left!=null && r.right==null)){
                return false;
            }

            if(l.right!=null && r.left!=null){
                q.add(l.right);
                q.add(r.left);
            }
            if((l.right==null && r.left!=null) || (l.right!=null && r.left==null)){
                return false;
            }
        }
        return true;
    }
}