/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
//Iterative
var isSymmetric = function(root) {
    if(root == null) return true;
    let stack = [];
    stack.push(root.left);
    stack.push(root.right);
    while( stack.length != 0){
        let right= stack.pop();
        let left = stack.pop();
        if(left == null && right == null) continue;
        if(left == null || right ==null || (right.val != left.val))return false;
        stack.push(left.left); stack.push(right.right);
        stack.push(left.right); stack.push(right.left);
            
        
        
    }
          
    return true;
    
    
};

//time complexity : O(n)
//space complexity : O(2h)

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
    if(root == null) return true;
    return helper(root.left, root.right);
    
    
};

var helper = function( left, right){
    //base
    if(left == null && right == null) return true;
    //logic
    if(left == null || right == null || left.val != right.val) return false;
    return helper(left.left, right.right) && helper(left.right,right.left);
    
}

//time complexity : O(n)
//space complexity : O(2h)