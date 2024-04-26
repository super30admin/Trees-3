//Time O(n^2)
 //Space O(n)
 //Leetcode yes
 //Issue none

class Solution {
public:
    void dfs(TreeNode* root, int targetSum, vector<int> &slate, vector<vector<int>> &res){
        if(!root) return;
        
        slate.push_back(root->val);

        if(!root->left && !root->right && (targetSum == root->val)){
            res.push_back(slate);
        }

        dfs(root->left, targetSum-root->val, slate, res);
        dfs(root->right, targetSum-root->val, slate, res);
        slate.pop_back();
    }

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> res;
        vector<int> slate;

        dfs(root, targetSum, slate, res);
        return res;
    }
};
