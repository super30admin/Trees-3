/**Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3 */

// Time Complexity : O(n) as it traverses and visits each node
// Space Complexity : O(edge) or O(n) as it covers each edge while traversing node in tree
// Did this code successfully run on Leetcode : Yes(100% faster)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach-There can be two ways to proceed-1. Using DFS(where we will be traversing node towards the depth until leaf node)-with Stack
//2. Using BFS(where we will cover each nodes at each level)-using queue
//DFS approach can be done both ways-recursive and iterative

class Solution{
    public boolean isSymmetric(TreeNode root){
        //edge case
        if(root == null) return true;
        return check(root.left, root.right);
    }
    //check/compare if two nodes across left and right subtrees are equal/exist either ways
    public boolean check(TreeNode left, TreeNode right){
        //base case
        //there will be two base cases
        //1. if both left and right nodes are null
        if(left == null && right == null) return true;
        //2. if either left or right node is null or if left node value is not equal to right node value
        if(left == null || right == null || left.val != right.val) return false;
        //else check Ll == Rr and Lr == Rl
        //checking if left child of left node is equal to right child of right node & right child of left node is equal to left child of right node
        return check(left.left, right.right) && check(left.right, right.left);
    } 
}