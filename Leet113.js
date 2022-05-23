// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
var pathSum = function(root, sum, res = [], path = []){
    if(root){
        path.push(root.val);
        if(!root.left && !root.right && sum - root.val === 0) res.push([...path]);
        pathSum(root.left, sum - root.val, res, path);
        pathSum(root.right, sum - root.val, res, path);
        path.pop();
    }
    return res;
};