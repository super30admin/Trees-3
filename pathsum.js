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

let result = [];
    let stack1 = [];
    let stackGlobal = [];
    let stack2 = [];
    
var pathSum = function(root, sum) {
    result = [];
     helper(root,0,sum,[]);  
    return result;
    
};

var helper = function(root,currSum, sum, path = []){
    //base
    if(root == null) return;
    //logic
    currSum = currSum + root.val;
    path.push(root.val);
    if(root.left == null && root.right == null){
        if(currSum==sum){
            result.push(path.slice());
        }
    }
    helper(root.left,currSum,sum,path);
    helper(root.right,currSum,sum,path);
    path.pop();
    
}

//time complexity : O(n)
//space complexity : O(h)-height of the tree