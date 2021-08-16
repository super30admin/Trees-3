// Time Complexity : O(N*N) where N is the number of nodes.
// Space Complexity :O(N*N) where N is the number of nodes of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(root == NULL){
            vector<vector<int>> x;
            return x;
        }
        vector<int> path;
        dfs(root, targetSum, path);
        return result;
    }
    void dfs(TreeNode* root, int targetSum, vector<int>& path){
        //base
        if(root == NULL){
            return;
        }
        //logic
        path.push_back(root->val);
        if(root->left == NULL && root->right == NULL){
            if((targetSum - root->val) == 0){
                result.push_back(path);
            }
        }
        dfs(root->left, targetSum-root->val, path);
        dfs(root->right, targetSum-root->val, path);
        //
    }
};

// Time Complexity : O(N) where N is the number of nodes.
// Space Complexity :O(N) where N is the number of nodes of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(root == NULL){
            vector<vector<int>> x;
            return x;
        }
        vector<int> path;
        dfs(root, targetSum, path);
        return result;
    }
    void dfs(TreeNode* root, int targetSum, vector<int>& path){//path passed by reference
        //base
        if(root == NULL){
            return;
        }
        //logic
        //action
        path.push_back(root->val);
        if(root->left == NULL && root->right == NULL){
            if((targetSum - root->val) == 0){
                result.push_back(path);
            }
        }
        dfs(root->left, targetSum-root->val, path);
        dfs(root->right, targetSum-root->val, path);
        //backtrack
        path.pop_back();
    }
};
