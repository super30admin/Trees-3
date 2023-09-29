import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;s
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//TC: O(N) SC: O(N) iterative dfs using stack
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        st.add(root.left);
        st.add(root.right);
        while(!st.isEmpty()) {
            TreeNode left = st.pop();
            TreeNode right = st.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            st.push(left.left);
            st.push(right.right);
            st.push(left.right);
            st.push(right.left);
        }
        return true;
    }
}
//TC: O(N) SC: O(H) DFS boolean based recursion
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root == null) return true;
//         return dfs(root.left, root.right);
//     }

//     private boolean dfs(TreeNode left, TreeNode right) {
//         //base
//         if(left == null && right == null) return true;
//         //logic
//         if(left == null || right == null || left.val != right.val) {
//             return false;
//         }
//         if(dfs(left.left, right.right) == false) return false;
//         return dfs(left.right, right.left);
//     }
// }

// DFS void based
// class Solution {
//     boolean flag;
//     public boolean isSymmetric(TreeNode root) {
//         if(root == null) return true;
//         this.flag = true;
//         dfs(root.left, root.right);
//         return flag;
//     }

//     private void dfs(TreeNode left, TreeNode right) {
//         //base
//         if(left == null && right == null) return;
//         //logic
//         if(left == null || right == null || left.val != right.val) {
//             flag = false;
//             return;
//         }
//         if(flag) dfs(left.left, right.right);
//         if(flag) dfs(left.right, right.left);
//     }
// }


//SC: O(N) TC: O(N) BFS using queue
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root == null) return true;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root.left);
//         q.add(root.right);
//         while(!q.isEmpty()) {
//             TreeNode left = q.poll();
//             TreeNode right = q.poll();
//             if(left == null && right == null) continue;
//             if(left == null || right == null) return false;
//             if(left.val != right.val) return false;
//             q.add(left.left);
//             q.add(right.right);
//             q.add(left.right);
//             q.add(right.left);
//         }
//         return true;
//     }
// }