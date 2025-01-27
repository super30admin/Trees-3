
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :No
public class Problem2 {
    boolean isSymmetricOrNot;
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        isSymmetricOrNot = true;
        //1st approach -> dfs(root.left,root.right);
        //2nd approach -> bfs(root);
        return isSymmetricOrNot;
    }

    // Time Complexity : O(n)
// Space Complexity : O(h)
    //while doing dfs we'll check if the left's left is equal to right's right and left's right is equal to right'left
    private void dfs(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return;
        }
        if(left == null || right == null){
            isSymmetricOrNot = false;
            return;
        }
        if(left.val != right.val){
            isSymmetricOrNot = false;
            return;
        }

        dfs(left.left,right.right);
        dfs(left.right,right.left);
    }



    // Time Complexity :O(n)
// Space Complexity :O(n) -> at any given point of time not all nodes are present in queue
    private void bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                isSymmetricOrNot = false;
                break;
            }
            if(left.val != right.val){
                isSymmetricOrNot = false;
                break;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
    }
}
