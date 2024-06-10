//Time Complexity - O(n)
 //Space - O(h)
 class Solution {
    boolean isSymm; 
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        isSymm = true;
        dfs(root.left,root.right);
        return isSymm;     
    }
    private void dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return;
        }
        if(left == null || right == null){
            isSymm = false;
            return;
        }
        
        if(left.val != right.val){
            isSymm = false;
            return;
        }
        dfs(left.left,right.right);
        dfs(left.right,right.left);
    }
}