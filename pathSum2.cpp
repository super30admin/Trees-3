// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <unordered_map>

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>>ans;
    void dfs(TreeNode* root, int tar, int curr, vector<int> path) {
        if(root != nullptr){
            curr += root->val;
            path.push_back(root->val);
        
        if (root->left == nullptr && root->right == nullptr){
            if (curr == tar) {
                ans.push_back(path);
            }
        }
        dfs(root->left,tar, curr, path);
        dfs(root->right, tar, curr, path);
        }

    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> path;
        dfs(root, targetSum, 0, path);
        return ans;
    }
};