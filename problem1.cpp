/*
Time complexity - O(N), we traversing through all nodes
Space complexity - O(N), in the worst cases we are storing all nodes
*/

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
    int target;    
    vector<vector<int>> res;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        target = targetSum;
        vector<int> temp;
        helper(root, 0, temp);
        return res;
    }
    
private:
    void helper(TreeNode* root, int currSum, vector<int> &temp){
        //base
        if (!root) return;     
        //logic
        currSum += root->val;
        temp.push_back(root->val);
        if (root->left == NULL && root->right == NULL){
            if (currSum == target) res.push_back(temp);
        }
        helper(root->left, currSum, temp);
        helper(root->right, currSum, temp);
        temp.pop_back();
    }
};