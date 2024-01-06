import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        //BFS
//        TC:O(n)
//        SC:O(n)
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;
    }
    boolean flag;
    public boolean isSymmetric2(TreeNode root) {
        //DFS
        if(root == null) return false;
        this.flag = true;
        helper(root.left, root.right);
        return flag;
    }
    private void helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return;
        if(left == null || right == null){
            flag = false;
            return;
        }
        if(left.val != right.val){
            flag = false;
            return;
        }
        if(flag)
            helper(left.left, right.right);
        if(flag)
            helper(left.right, right.left);
    }


    public boolean isSymmetric3(TreeNode root) {
        //DFS
        if(root == null) return false;
        return helper2(root.left, root.right);
    }
    private boolean helper2(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null){
            return false;

        }
        if(left.val != right.val){
            return false;
        }
        if(!helper2(left.left, right.right)) return false;
        return helper2(left.right, right.left);
    }
}
