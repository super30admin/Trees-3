// Time Complexity :O(n^2) where n in the number of nodes in a tree
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
            vector<int> res;
            vector<vector<int>> ans;
            solvePathSum(root,targetSum,res,ans);
            return ans;
        }
        void solvePathSum(TreeNode* root,int targetSum,vector<int> &res,vector<vector<int>> &ans){
            if(!root) return;
            res.push_back(root->val);
            if(!root->left and !root->right){
                if(root->val == targetSum){
                    ans.push_back(res);
                }
            }
            solvePathSum(root->left,targetSum-(root->val),res,ans);
            solvePathSum(root->right,targetSum-(root->val),res,ans);
            res.pop_back();
        }
};