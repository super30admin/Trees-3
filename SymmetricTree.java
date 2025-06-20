//DFS: recursion
//TC=O(n), SC=O(h)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        //base
        if(left==null && right==null) return true;
        //logic
        if(left==null || right==null || left.val!=right.val) return false;
        return helper(left.left, right.right) && helper(left.right,right.left);
    }
}

//  //BFS: single queue
//  //TC=O(n), SC=O(n)
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root == null) return true;
//         Queue <TreeNode> q = new LinkedList<>();
//         q.offer(root.left);
//         q.offer(root.right);
//         while(!q.isEmpty()){
//             TreeNode left = q.poll();
//             TreeNode right = q.poll();
//             if(right == null && left == null) continue;
//             if(left == null || right == null || left.val != right.val) return false;
//             q.offer(left.left);
//             q.offer(right.right);
//             q.offer(left.right);
//             q.offer(right.left);
//         }
//         return true;
//     }
// }

// //Iterative:
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root==null) return true;
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root.right);
//         stack.push(root.left);
//         while(!stack.isEmpty()){
//             TreeNode left =stack.pop();
//             TreeNode right =stack.pop();
//             if(left == null && right == null) continue;
//             if(left==null || right==null || left.val!=right.val) return false;
//             stack.push(right.right);
//             stack.push(left.left);
//             stack.push(right.left);
//             stack.push(left.right);
//         }
//     return true;
//    }
// }