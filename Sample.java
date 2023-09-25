               // Path Sum II

// Time Complexity : O(n)
// Space Complexity : O(n)  .. recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    List<List<Integer>> list;

    private void traverse(TreeNode root, int targetSum, List<Integer> addList){
        if(root == null){
            return;
        }
        
        addList.add(root.val);
        targetSum -= root.val;

        if(root.left == null && root.right == null && targetSum == 0){
            list.add(new ArrayList(addList));
            return;
        }
        traverse(root.left, targetSum, new ArrayList(addList));
        traverse(root.right, targetSum, new ArrayList(addList));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new ArrayList();
        traverse(root, targetSum, new ArrayList());
        return list;
    }
}

               // Symmetric Tree

// Time Complexity : O(n)
// Space Complexity : O(n)  .. recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    private boolean isBST(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        
        if(root1 == null || root2 == null)
            return false;
        
        if(root1.val != root2.val)
            return false;
        
        return isBST(root1.left, root2.right) && isBST(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isBST(root.left, root.right);
    }
}
