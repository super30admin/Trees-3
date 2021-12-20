// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

class Solution {
public:
    vector<vector<int>>paths;
    
    void getSum(TreeNode *root,int targetSum,int curSum,vector<int> curPath)
    {
        if(root==nullptr)
        {
            return;
        }
        if(root->left==nullptr && root->right==nullptr && ((curSum+root->val)==targetSum))
        {
            curPath.push_back(root->val);
            vector<int>path(curPath);
            paths.push_back(path);
            //paths.push_back(curPath);
        }
        curSum=curSum+root->val;
        curPath.push_back(root->val);
        getSum(root->left,targetSum,curSum,curPath);
        getSum(root->right,targetSum,curSum,curPath);
        curSum-=root->val;
        curPath.pop_back();
    }    
        
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if (root==nullptr)
        {
            vector<vector<int>>temp;
            temp.resize(0);
            return temp;
        }
        vector<int>curPath;
        getSum(root,targetSum,0,curPath);
        return paths;
    }
};
