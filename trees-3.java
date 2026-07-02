// Approach:
// 1. Perform a DFS traversal while maintaining the current path and its sum.
// 2. Add the current node's value to the path and update the running sum.
// 3. If the current node is a leaf and the running sum equals the target sum,
//    add a copy of the current path to the result.
// 4. Recursively explore the left and right subtrees.
// 5. After visiting both subtrees, remove the current node from the path
//    (backtracking) to explore other paths.

// Time Complexity: O(n)
// Space Complexity: O(h)
// h = height of the tree (excluding the output list)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         this.res=new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root,int targetSum,int currentsum,List<Integer> path){
        if(root==null) return;
        currentsum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currentsum==targetSum){
                res.add(new ArrayList<>(path));
            }
        }
        helper(root.left,targetSum,currentsum,path);
        helper(root.right,targetSum,currentsum,path);
        path.remove(path.size()-1);
    }
}
//problem-2
// Approach:
// 1. Compare the left and right subtrees recursively.
// 2. If both nodes are null, they are symmetric.
// 3. If one node is null or their values differ, return false.
// 4. Compare the left child of the left subtree with the right child of the right subtree.
// 5. Compare the right child of the left subtree with the left child of the right subtree.
// 6. The tree is symmetric only if both recursive comparisons return true.

// Time Complexity: O(n)
// Space Complexity: O(h)
// h = height of the tree (recursion stack)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
