//time complexity: O(n)
//space complexity:O(n)
//approach: recursion
//solved on leetcode? yes
//problem faced? no

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>>res;
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        if(root==NULL)
            return res;
        vector<int>path;
        helper(root,sum,path);
        return res;
    }
    void helper(TreeNode* root,  int sum, vector<int>path)
    {
        if(root==NULL)
            return;
        if(root->left==NULL && root->right==NULL)
        {
            if(sum-root->val==0)
            {
                path.push_back(root->val);
                res.push_back(path);
            }
            return;
        }
        path.push_back(root->val);
        helper(root->left,sum-root->val,path);
        helper(root->right,sum-root->val,path);
        return;
    }
};