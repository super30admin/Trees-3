//Path Sum II (LC 113)

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I recurse through the tree and push values that add up to the sum


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
 * @param {number} sum
 * @return {number[][]}
 */
var pathSum = function(root, sum) {
    let pathsList = [];
    let pathNodes = [];
    recurseTree(root, sum, pathNodes, pathsList);
    return pathsList;
};

let recurseTree = function(node, remainSum, pathNodes, pathsList){
    if(node === null){
        return;
    }
    pathNodes.push(node.val);
    if(remainSum === node.val && node.left === null && node.right === null){
        pathsList.push(pathNodes);
    } else {
        recurseTree(node.left, remainSum - node.val, pathNodes, pathsList);
        recurseTree(node.right, remainSum - node.val, pathNodes, pathsList);
    }
    pathNodes.pop();
}