//Leetcode : https://leetcode.com/problems/symmetric-tree/
// Time Complexity : O(n) - to compare all the nodes of tree
// Space Complexity : O(n) - call stack space; else O(1)
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
    //Brute force solution; O(n+n+n)=> O(n) TC ; O(n+n) => O(n) SC

    // let leftTree = [];
    // let rightTree = [];

    // var preorderTree = (root) => { //O(n)
    //     //base case
    //     if(root === null) {leftTree.push(null); return};
        
    //     //recursive case
    //     leftTree.push(root.val);
    //     preorderTree(root.left);
    //     preorderTree(root.right);
    // }

    // var reversePreorderTree = (root) => { //O(n)
    //     //base case
    //     if(root === null) {rightTree.push(null); return};
        
    //     //recursive case
    //     rightTree.push(root.val);
    //     reversePreorderTree(root.right)
    //     reversePreorderTree(root.left);
    // }

    // preorderTree(root.left);
    // reversePreorderTree(root.right);

    //     let n = leftTree.length
    //     for(let i=0;i<n;i++){ //O(n)
    //         if(leftTree[i] != rightTree[i])
    //             return false;
    //     }
    // return true;


    // Solution using DFS. 
    const dfs = (node1, node2) => {
        //base
        if(node1 === null && node2 === null) return true; // check base case

        //logic; check unequality between nodes and their values
        if((node1 !== null && node2 === null )|| 
        (node2 !== null && node1 === null) || 
        (node1.val != node2.val)) return false;

        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left); // Compare the left side of the tree to right side of tree at every recursion
    }

    return dfs(root.left, root.right)
};