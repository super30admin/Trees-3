/* Approach 1
 Recursive-

 TC - O(N) we are traversing all the nodes
 Time complexity : O(n). Because we traverse the entire input tree once, the total run time is O(n), where n is the total number of nodes in the tree.

 SC - O(N)  The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in
O(n). Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case.
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

 */
public class Symmetric_Tree_LC_101 {
    public boolean isSymmetric(TreeNode root) {

        return isSame(root, root);
    }

    public boolean isSame(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;



        return (root1.val == root2.val) && isSame(root1.right,root2.left) &&  isSame(root1.left,root2.right);

    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}