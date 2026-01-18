class Solution {
public:
    vector<vector<int>> answer;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> path;
        helper(root, targetSum, 0, path); 
        return answer;
    }
    void helper(TreeNode* root, int targetSum, int currSum, vector<int> path) {
        // termination condition
        if (root == nullptr)
            return;

        //logic
        if (root->left == nullptr && root->right == nullptr && currSum+root->val == targetSum) {
            path.push_back(root->val);
            answer.push_back(path);
            return ;
        }
        currSum+=root->val;
        path.push_back(root->val);

        //recursion
        helper(root->left, targetSum, currSum, path);
        helper(root->right, targetSum, currSum, path);
    }
};
