// Time Complexity :O(n) n is the number of nodes is the tree and time if for recursive call on every node (we make a deep copy of prev list only at every leaf node)
// Space Complexity :O(h)  where h is the height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 3: BFS
//TC:O(n) SC: O(n) n is the number of nodes
public class SymmetricTree {
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
            if(root == null)
                return true;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root.left);
            q.add(root.right);

            while(!q.isEmpty()){
                TreeNode left = q.poll();
                TreeNode right = q.poll();

                if(left == null && right == null)
                    continue;

                if(left == null || right == null || left.val != right.val)
                    return false;

                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }
            return true;
        }
    }
}

//Method 2: DFS using boolean return type
//TC: O(n) and SC: O(h)
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

        if(root == null)
            return true;
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right){

        //base case
        if(left == null && right == null)
            return true;

        if(left == null || right == null || left.val != right.val){
            return false;
        }

        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }
}



//Method 1: DFS using void return type
//TC: O(n) and SC: O(h)
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
    boolean flag;
    public boolean isSymmetric(TreeNode root) {

        if(root == null)
            return true;
        flag = true;
        dfs(root.left,root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right){

        //base case
        if(left == null && right == null)
            return;

        if(left == null || right == null || left.val != right.val){
            flag  = false;
            return;
        }
        if(flag)
            dfs(left.left,right.right);
        if(flag)
            dfs(left.right,right.left);
    }
}