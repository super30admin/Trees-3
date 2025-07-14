class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        Queue<TreeNode>s = new LinkedList<>();
        s.add(root.left);
        s.add(root.right);
        while(!(s.isEmpty())){
            TreeNode left = s.poll();
            TreeNode right = s.poll();

            if(left==null && right==null){
                continue;
            }

            if(left==null || right==null){
                return false;
            }

            if(left.val!=right.val){
                return false;
            }

            s.add(left.left);
            s.add(right.right);
            s.add(left.right);
            s.add(right.left);
        }return true;
    }
}
