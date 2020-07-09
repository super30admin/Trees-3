//Symmetric Tree (LC 101)

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Iterating and looking at two consecutive nodes in the queue.


// Your code here along with comments explaining your approach

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
    let queue = [];
    queue.push(root);
    queue.push(root);
    while(queue.length > 0){
        let num1 = queue.pop();
        let num2 = queue.pop();
        if(num1 === null && num2 === null) {
            continue;
        }
        if(num1 === null || num2 === null) {
            return false;
        }
        if(num1.val !== num2.val){
            return false;
        }
        queue.push(num1.left);
        queue.push(num2.right);
        queue.push(num1.right);
        queue.push(num2.left);
    }
    return true;
};