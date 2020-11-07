// Time Complexity : O(N)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


var pathSum = function(root, sum) {
    let result = [];
    if(root == null) return Array.from(result);

    helper(root, 0,[]);
    return result;

    function helper(root, currSum, path){
        if(root == null) return 

        if(currSum + root.val == sum && root.left == null && root.right == null){
           
                path.push(root.val)
                result.push(path.slice())
                return            
        }
        path.push(root.val)
        helper(root.left, currSum + root.val, path.slice())
        helper(root.right, currSum + root.val, path.slice())
    }
}; 