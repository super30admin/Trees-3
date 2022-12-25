import java.util.*;

//BSF Solution
// Time Complexity : O(n)
// Space Complexity : O(n) // it will be n/2 for leaf node which will be max

/*
 * add the left and right of the root to the queue and compare the first two
 * values add left child of the first and right child of the second.
*/

 public class SymmetricTree {
    Queue<TreeNode> q;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()){
            TreeNode first = q.poll();
            TreeNode second = q.poll();
            if(first == null && second == null) continue;
            if(first == null || second == null || first.val != second.val) return false;
            q.add(first.left); q.add(second.right);
            q.add(first.right); q.add(second.left);
        }
        return true;
    }
}

//DFS Solution
// Time Complexity : O(n)
// Space Complexity : O(n)

/*
 * call the DFS function on left and right and if they are not same reutrn false.
 * then call the DFS function onleft of left and right of right and vis a versa.
*/
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        flag = true;
        dfs(root.left, root.right);
        return flag;
    }

    public void dfs(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return;
        //logic
        if(left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }
        if(flag)    dfs(left.left, right.right);
        if(flag)   dfs(left.right, right.left);       
    }
}