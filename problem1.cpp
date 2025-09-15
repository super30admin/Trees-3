// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Start from the root and run a dfs, accumulating all the nodes in the traversed path
// Once we reach a leaf node, check the sum of the path and if it matches the target sum, add it to the result vector
// When we finish exploring a path and backtrack, pop the node from the path vector

class Solution {
    void helper(TreeNode* root, const int& targetSum, int currentSum, vector<int>& path, vector<vector<int>>& result) {
        // base
        if(!root) return;
        // logic
        currentSum += root->val;
        path.push_back(root->val);
        if(!root->left && !root->right) {
            if(currentSum == targetSum) {
                result.push_back(path);
            }
        }
        helper(root->left, targetSum, currentSum, path, result);
        helper(root->right, targetSum, currentSum, path, result);
        path.pop_back();
    }
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> path;
        vector<vector<int>> result;
        helper(root, targetSum, 0, path, result);
        return result;
    }
};