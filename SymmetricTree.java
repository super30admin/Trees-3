// Time Complexity:O(n)
//space Complexity:O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkTree(root.left,root.right);
    }
    public boolean checkTree(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        else if((root1==null&&root2!=null)||(root1!=null&&root2==null)||root1.val!=root2.val){
            return false;
        }
        else{
        if(!checkTree(root1.left,root2.right)) return false;
        if(!checkTree(root1.right,root2.left)) return false;
        }
        return true;
    }

}