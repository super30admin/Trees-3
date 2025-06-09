// ## Problem1 (https://leetcode.com/problems/path-sum-ii/)


// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE, had to send deep copy to res was not Intuitive 

var pathSum = function(root, targetSum) {
    //Time COmplexity : O(n)
    //Space COmplexity : O(h)
    let res = [];
    function dfs(root, currentSum, path) {
        if (!root) return;
        path.push(root.val)
        if (!root.left && !root.right && currentSum + root.val === targetSum) {
            //Here we have to push the deep copy
            // https://www.youtube.com/watch?v=A8reGuUhCA0&ab_channel=%7BS30%7D
            //Because its the same reference ! Time Stamp 48:55
             res.push([...path]);
        }
        dfs(root.left, currentSum + root.val, path);
        dfs(root.right, currentSum + root.val, path);
        path.pop()
    }
    dfs(root, 0, []);
    return res;
};


// var pathSum = function(root, targetSum) {
//         // Time Complexity : O(N*H)
// // Space Complexity : O(n*h)
//     let res = [];
//     function dfs(root, currentSum, path) {
//         if (!root) return;
//         //Create a new path with all the elements traversed from root
//         //Here the ...path will take a complexity of O(h) for everynode that means o(nh)
//         let newPath = [...path, root.val];
//         if (!root.left && !root.right && currentSum + root.val === targetSum) {
//             //Push the path to res
//             res.push(newPath);
//             return;
//         }
//         dfs(root.left, currentSum + root.val, newPath);
//         dfs(root.right, currentSum + root.val, newPath);
//     }
//     dfs(root, 0, []);
//     return res;
// };
