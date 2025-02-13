// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Traverse from root to leaf, if the sum is equal to the target then add this vector to our result. 
// Else pop the last element and return.
// Continue the recursion.



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
        void helper(TreeNode* root, int targetSum, vector<vector<int>> &ans, vector<int> &res, int curr){
            if(root == NULL) return;
            curr += root->val;
            res.push_back(root->val);
            if(root->left == NULL && root->right == NULL){
                if(curr == targetSum) ans.push_back(res);
            }
            else{
                helper(root->left, targetSum, ans, res, curr);
                helper(root->right, targetSum, ans, res, curr);
            }        
            res.pop_back();
    
        }
        vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
            vector<vector<int>> ans;
            vector<int> res;
            helper(root, targetSum, ans, res, 0);
            return ans;
        }
    };