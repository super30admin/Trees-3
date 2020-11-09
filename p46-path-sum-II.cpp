// Time complexity is O(n) - n is the number of nodes
// Space complexity is O(1) - 'res' 2-D vector is returned
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    
    void helper(TreeNode* root, int currSum, vector<int> path,vector<vector<int>>& res, int sum) {
        //base
        if(root == nullptr) return;
           
        //logic
        if(root->left == nullptr && root->right == nullptr) {
            if(currSum == sum) {
                res.push_back(path);
            }
            return;
        }
        
        if(root->left) {
            path.push_back(root->left->val);
            helper(root->left, currSum+root->left->val, path, res, sum);
            path.pop_back();
        }
        
        if(root->right) {
            path.push_back(root->right->val);
            helper(root->right, currSum+root->right->val, path, res, sum);
            path.pop_back();
        }
        return;
    }
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        if(root == nullptr){
            return {};
        }
        vector<vector<int>> res;
        vector<int> path;
        path.push_back(root->val);
        helper(root, root->val, path, res, sum);
        return res;
    }
};
