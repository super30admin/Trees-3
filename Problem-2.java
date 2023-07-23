class Solution {
    //Time Complexity :- O(n)
    //Space COmplexity:- O(1)
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        TreeNode x = root;
        TreeNode y = root;
        flag = true;
        symmetri(x,y);
        return flag;
    }
    private void symmetri(TreeNode x,TreeNode y){
        if(x == null && y == null) return;
        if(x == null || y == null) {
            flag = false;
            return;
        }
        
        if(x == null || y == null || x.val != y.val) flag = false;
        System.out.println(x.val+" "+y.val);
        symmetri(x.left,y.right);
        symmetri(x.right,y.left);
    }
}