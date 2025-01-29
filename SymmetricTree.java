// In this problem, we are making 2 recursive calls with left's left,right's right anf left's right, right's left. For issymmetric, 
// they should be equal.

// Time Complexity : O(n) - no. of nodes
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Return type void version:
class Solution {
    // Declaring isSymmetric in global scope
    boolean isSymmetric;

    public boolean isSymmetric(TreeNode root) {
        // If root is null then tree is Symmetric
        if (root == null) {
            return true;
        }
        // In java by default boolean value is false, so set it to true
        isSymmetric = true;
        // Make a recursive call with root's left and right
        dfs(root.left, root.right);
        // Return isSymmetric value
        return isSymmetric;
    }

    private void dfs(TreeNode left, TreeNode right) {
        // Check if in any in between call, isSymmetric has become false, then no need
        // to check further, just return
        if (isSymmetric == false) {
            return;
        }
        // If both left and right are null, that means that node is symmetric, just
        // return
        if (left == null && right == null) {
            return;
        }
        // If one of it is null and one is not, then it is not Symmetric
        if (left == null || right == null) {
            // So set it to false and return
            isSymmetric = false;
            return;
        }
        // Value of both is not equal then not Symmetric
        if (left.val != right.val) {
            // Set it to false and return
            isSymmetric = false;
            return;
        }
        // Make 2 recursive calls
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}

// Return type boolean version - same tc and sc
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // If root is null then tree is Symmetric
        if (root == null) {
            return true;
        }
        // Make a recursive call with root's left and right
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        // If both left and right are null, that means that node is symmetric, just
        // return
        if (left == null && right == null) {
            return true;
        }
        // If one of it is null and one is not, then it is not Symmetric
        if (left == null || right == null) {
            // So return false
            return false;
        }
        // Value of both is not equal then not Symmetric
        if (left.val != right.val) {
            // Return false
            return false;
        }
        // Make 2 recursive calls
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}

// BFS Algo:
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return true;
    }
}

// BFS algo, for printing each level on different line
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                System.out.print(curr.val + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println("");

        }
        return true;
    }
}

// Solution to lc question using bfs:
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Base case
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        // Add left and right to the queue
        q.add(root.left);
        q.add(root.right);
        // Iterate till queue is empty
        while (!q.isEmpty()) {
            // Pop the left and right for comparison
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            // If both null, symmetric
            if (left == null && right == null) {
                continue;
            }
            // If one null, not symmetric
            if (left == null || right == null) {
                return false;
            }
            // If the value of both are not equal, not symmetric
            if (left.val != right.val) {
                return false;
            }
            // Perform the same with left's left, right's right and left's right, right's
            // left
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;
    }
}