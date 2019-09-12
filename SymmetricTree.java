
//Space complexity: O(N) N being the height of the tree
//time complexity: O(N)
//Ran on leetcode and accepted on submission
class Solution 
{
    public boolean isSymmetric(TreeNode root) 
    {
        //A function to check for symmetry
        return isMirror(root, root);
    }
    //Checks for symmetry at every node
    public boolean isMirror(TreeNode t1, TreeNode t2) 
    {
        //if the left and right is null then symmetric so return true
        if(t1==null && t2 ==null) return true;
        else
        //If only one of the sides is null and other is not then no symmetry return false
            if(t1 == null || t2 == null) return false;
        //If the value at left and right node match and the left is symmetric to right and right is symmetric to left then return the result 
        //if all 3 are true the it returns true of any one is not true then it will return false
        return (t1.val == t2.val) && isMirror(t1.right,t2.left) && isMirror(t1.left, t2.right);
    }
}