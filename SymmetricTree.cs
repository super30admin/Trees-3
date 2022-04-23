// Time Complexity : O(n/2) -> traversin only half of eleemnts, O(n)
// Space Complexity : O(h) h is heigh tof tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 2) these condition will check if its mirror.
//     a. now call dfs to match left left to right right
//     b. now call dfs to match left right to right left
// 3) if left is null or right is null or left val is nto equal to right val, return false
// 4) Otherwise return true

public bool IsSymmetric(TreeNode root) {
        
    if(root == null)
        return true;

    //call dfs
    return dfs(root.left, root.right);        
}

private bool dfs(TreeNode left, TreeNode right)
{
    //base condition
    //if left and right is null, it is valid, just return it
    if(left == null && right == null)
        return true;
    
    //if left is null or right is null or left val is nto equal to right val, return false
    if(left == null || right == null || left.val != right.val)            
        return false;                

    //these conditon will check if its mirror.
    //now call dfs to match left left to right right
    //now call dfs to match left right to right left
    return dfs(left.left, right.right) && dfs(left.right, right.left);
    
    //OR
    //var case1 = dfs(left.left, right.right);
    //var case2 = dfs(left.right, right.left);
    //return case1 && case2;
}