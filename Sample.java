/******************************PROBLEM-1*******************/
// Time Complexity : 0(n)
// Space Complexity : 0(h)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return new ArrayList<>();
        }

        dfs(root,0,new ArrayList<>(),targetSum);
        return result;
    }

    private void dfs(TreeNode root,int sum,List<Integer> path,int targetSum){
        if(root==null){
            return;
        }

        sum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        dfs(root.left,sum,path,targetSum);
        dfs(root.right,sum,path,targetSum);
        path.remove(path.size()-1);
    }
}
/******************************PROBLEM-2*******************/
// Time Complexity : 0(N)
// Space Complexity : 0(H)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean isSymmetric=true;
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        dfs(root.left,root.right);

        return isSymmetric;

    }

    private void dfs(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return;
        }
        if(left==null || right==null){
            isSymmetric=false;
            return;
        }
        if(left.val != right.val){
            isSymmetric=false;
            return;
        }
        dfs(left.left,right.right);
        dfs(left.right,right.left);
    }
}

// Time Complexity : 0(N)
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        boolean isSymmetric = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                isSymmetric = false;
                break;
            }
            if (left.val != right.val) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return isSymmetric;
    }
}