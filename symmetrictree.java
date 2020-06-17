//Time Complexity: O(n)
//Space complexity:O(n)


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root.left,root.right);
    }
    
    private boolean helper(TreeNode treeleft, TreeNode treeright){
        if(treeleft==null && treeright == null){
            return true;
        }
        if(treeleft==null || treeright == null){
            return false;
        }
        if(treeleft.val !=treeright.val){
            return false;
        }
        if(helper(treeleft.left,treeright.right)==false){
            return false;
        }
        return helper(treeleft.right,treeright.left);
    }
}