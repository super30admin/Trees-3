class Solution {
public:
    //TC-O(N)
    //SC-O(N)
    bool isleaf(TreeNode* root){
        if(!root->left&&!root->right)return true;
        return false;
    }
    void findpaths(TreeNode* root, int targetSum,vector<int>&path,vector<vector<int>>&paths){
        if(!root)return;
        path.push_back(root->val);
        if(isleaf(root)&&root->val==targetSum){
            paths.push_back(path);
        }
        findpaths(root->left,targetSum-root->val,path,paths);
        findpaths(root->right,targetSum-root->val,path,paths);
        path.pop_back();
        
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> paths;
        vector<int>path;
        if(!root)return paths;
        findpaths(root,targetSum,path,paths);
       return paths;
    }
};