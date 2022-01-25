public class IsSymmetric {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Boolean flag;
    public boolean isSymmetric(TreeNode root) {
        flag = true;
        if(root == null) return true;

        dfs_helper_2(root.left, root.right);
        return flag;
    }

    private void dfs_helper(TreeNode left, TreeNode right){

        //base
        if(left == null && right == null) {
            flag = true;
            return;
        }
        if( (left == null && right != null) || (left != null && right == null) || (left.val != right.val)){
            flag = false;
            return;
        }

        //logic
        dfs_helper(left.left, right.right);
        if(flag) dfs_helper(left.right, right.left);
    }

    private void dfs_helper_2(TreeNode left, TreeNode right){

        if(!flag){
            flag = false;
            return;
        }
        //base
        if(left == null && right == null) {
            flag = true;
            return;
        }
        if( (left == null && right != null) || (left != null && right == null) || (left.val != right.val)){
            flag = false;
            return;
        }

        //logic
        dfs_helper_2(left.left, right.right);
        dfs_helper_2(left.right, right.left);
    }

    public static void main(String[] args) {

        TreeNode t5_1 = new TreeNode(5, null, null);
        TreeNode t5_2 = new TreeNode(5, null, null);

        TreeNode t4 = new TreeNode(4, null, null);

        TreeNode t3_1 = new TreeNode(3, t4, t5_1);
        TreeNode t3_2 = new TreeNode(3, t5_2, null);

        TreeNode t2 = new TreeNode(2, t3_1, t3_2);

        System.out.println("isSymmetric : " + new IsSymmetric().isSymmetric(t2));
//        System.out.println("isSymmetric : " + new IsSymmetric().isSymmetric(t2));
    }

}
