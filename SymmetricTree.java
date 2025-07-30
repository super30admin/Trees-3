// Time Complexity : O(n) n = no of nodes and we traverse each node once in recursive
// Space Complexity : O(h) h = ht of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We need to check if a binary tree is symmetric around its center.
// The idea is to recursively compare the left subtree and the right subtree.
// For symmetry:
// - Left subtree's left should match right subtree's right.
// - Left subtree's right should match right subtree's left.
// If any mismatch is found, we set the `isSym` flag to false.


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

public class SymmetricTree {
    boolean isSym;
    public boolean solve(TreeNode root){
        if(root==null){
            return true;
        }
        //isSym=true;
        return dfs_func(root.left, root.right);
        //return isSym;
    }
    private boolean dfs_func(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        boolean case1 = dfs_func(left.left, right.right);
        boolean case2 = dfs_func(left.right, right.left);
        return case1 && case2;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1, 
                            new TreeNode(2, new TreeNode(3), new TreeNode(4)), 
                            new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        
        SymmetricTree ob = new SymmetricTree();
        System.out.println("Is tree symmetric ? "+ob.solve(root));

        TreeNode root2 = new TreeNode(1,
                                new TreeNode(2, null, new TreeNode(3)),
                                new TreeNode(2, null, new TreeNode(3)));
        
        System.out.println("Is tree symmetric ? " +ob.solve(root2));
    }
    
}
