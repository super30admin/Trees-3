import java.util.LinkedList;
import java.util.Queue;

/*
DFS approach
Time Complexity -> O(N)
Space Complexity -> O(H)
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return dfs(root.left, root.right);
        
    }

    private boolean dfs(TreeNode left, TreeNode right) {

        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);

    }
}
/*
DFS approach
Time Complexity -> O(N)
Space Complexity -> O(H)
*/

class Solution2 {
    boolean isSymmetric;

    public boolean isSymmetric(TreeNode root) {
        isSymmetric = true;
        if (root == null) {
            isSymmetric = true;
        }
        dfs(root.left, root.right);
        return isSymmetric;

    }

    private void dfs(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return;
        }
        if (left == null || right == null) {
            isSymmetric = false;
            return;
        }
        if (left.val != right.val) {
            isSymmetric = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);

    }
}

/*
BFS approach Leve order Traversal
Time Complexity -> O(N)
Space Complexity -> O(N)
*/

class Solution3 {
    boolean isSymmetric;

    public boolean isSymmetric(TreeNode root) {
        isSymmetric = true;
        if (root == null) {
            isSymmetric = true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                isSymmetric = false;
                break;
            }
            if(left.val != right.val) {
                isSymmetric = false;
                break;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        
        return isSymmetric;

    }

}