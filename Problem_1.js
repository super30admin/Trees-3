//Leetcode : https://leetcode.com/problems/path-sum-ii/
// Time Complexity : O(n) - n is numb er of nodes
// Space Complexity : O(n) - worst case scenario, all the elements can be target sum and can be present in the result; 
//                    O(h) - call stack space as well but n >~ h so O(n)
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
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {
    let result = [];

    //let list = [] // can be global var too instead of  list with backtracking solution. 
    var helper = (root, targetSum, currSum, list) => {
        //Solution 1: Below way is to use extra space to solve the reference problem i.e. O(n*h) => O(n^2): 

        // if(root === null) return;
        // let path = JSON.parse(JSON.stringify(list)); // Deep copy to new array in JS, cant pass list directly since it is a reference and will add all the node values to the result
        // currSum+=root.val;
        // path.push(root.val);
        // if(root.left === null && root.right === null){
        //     if(currSum === targetSum)
        //         result.push(path);
        //     return;
        // }
        // helper(root.left, targetSum, currSum, path)
        // helper(root.right, targetSum, currSum, path)

        //Solution 2:Below solution uses back tracking to remove the extra space and reference issue as well:
        if(root === null) return;
        currSum+=root.val;
        list.push(root.val);
        if(root.left === null && root.right === null){
            if(currSum === targetSum)
                result.push(JSON.parse(JSON.stringify(list)));
        }
        helper(root.left, targetSum, currSum, list)
        helper(root.right, targetSum, currSum, list)
        list.pop(); // backtracking here by removing the last added value post recursing the left and right
    }
    helper(root, targetSum, 0, [])
    return result;
};