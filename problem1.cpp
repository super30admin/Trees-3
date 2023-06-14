// Time Complexity : O(n)
// Space Complexity : O(h) where h = height of tre (stack space for recurrsion)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> allpaths;
        vector<int> currpath;
        findPaths(root, targetSum, currpath, allpaths);
        return allpaths;  
    }

    void findPaths(TreeNode* root, int targetSum, vector<int>& currpath, vector<vector<int> >& allpaths) {
        if(!root)
            return;
        currpath.push_back(root->val);

        targetSum = targetSum - root->val;

        if(targetSum==0 && !root->left && !root->right)
            allpaths.push_back(currpath);

        findPaths(root->left,targetSum, currpath, allpaths);
        findPaths(root->right,targetSum, currpath, allpaths);
        
        currpath.pop_back();

        }
};