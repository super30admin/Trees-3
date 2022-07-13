public class SymmetricTree {
    // TC is O(n)
    // SC is O(n/2)
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) continue;
            if(left != null && right == null) return false;
            if(left == null && right != null) return false;
            if(left.val != right.val)  return false;
            if(left.left != null && right.right != null && left.left.val != right.right.val) return false;
                if(left.right != null && right.left != null && left.right.val != right.left.val) return false;
            
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
    }
        return true;
}
}
