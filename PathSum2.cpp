// Time Complexity : o(n)
// Space Complexity : o(n)
// Where n = number of elements in the list given
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
public:
    vector<vector<int>> list;
    void helper(TreeNode *root, int sum, int target, vector<int> rootToLeafPath) {
        if(root==NULL) return;
        if(!root->left && !root->right && sum+root->val == target) {
            rootToLeafPath.push_back(root->val);
            list.push_back(rootToLeafPath);
            return;
        }
        rootToLeafPath.push_back(root->val);
        helper(root->left,sum+root->val,target,rootToLeafPath);
        helper(root->right,sum+root->val,target,rootToLeafPath);
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> rootToPath;
        helper(root, 0, targetSum, rootToPath);
        return list;
    }
};