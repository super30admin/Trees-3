// 101. Symmetric Tree - Recursive Solution
// Time Complexity : O(n)
// Space Complexity : O(h) where h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
    //base case - check if the root is present (null node considered as Symmetric  tree)
    if(root == null) return true
    //recursive call by passing left and right of root initially
    return helper(root.left, root.right)
};

var helper = function(left, right){
    //Base case
    //if left and right of root is null - the tree is considered Symmetric 
    if(left == null && right == null) return true
    //conditions which makes the tree un-Symmetric
    if(left == null || right == null || left.val != right.val) return false
    //Logic
    /*
    Conditions for symmetry are (left->left == right->right) & (left->left == right->right)
            root
          /      \
      left       right
     /   \       /   \
  left  right  left  right
    */  
    return helper(left.left, right.right) && helper(left.right, right.left)
};


// 101. Symmetric Tree -   Iterative Solution
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @return {boolean}
 */

var isSymmetric = function(root) {
    //base case - check if the root is present (null node considered as Symmetric  tree)
    if(root == null) return true
    // initialize stack and push left and right of the root
    var stack = []
    stack.push(root.left)
    stack.push(root.right)
    // keep on popping left and right, then push the nodes in the next level until all levels are done.
    while(!stack.length == 0) {
        right = stack.pop() 
        left = stack.pop()
        // Continue in this as (either or -> (left.left != right.right) and (left.right != right.left) would fail.
        if(left == null && right == null) continue
        if(left == null || right == null || left.val != right.val) return false
        stack.push(left.left)
        stack.push(right.right)
        stack.push(left.right)
        stack.push(right.left)
    }
    return true;
};




