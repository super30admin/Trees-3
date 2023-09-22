class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode left = q.poll();
                TreeNode right = q.poll();

              if(left == null && right == null) continue;
              if(left == null || right == null || left .val != right.val) return false;
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }
        }
        return true;
    }
}






Class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        flag = true;
        dfs(root.left, root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right){
        if(left == null && right == null) return;

        if(left == null || right == null || left.val != right.val){
            flag = false;
            return;
        }

        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}




/**
TC : O(n) 
Sc : O(n) --> Maintaing queue

Description : Maintaning a queue and adding both left and right first. Then Comapring whether they both are equal or not. Storing first node in left and second node in right. Comparing both nodes and returing false if both are not same. 





 */