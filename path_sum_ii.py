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
    vector<vector<int>> total_paths;
    vector<int> path;
    vector<vector<int>> pathSum(TreeNode* root, int sum) 
    {
        
        if(root==NULL)
        {
            return total_paths;
        }
        else
        {
            
            int s_sum = sum-root->val;
            path.push_back(root->val);
            if(s_sum==0 && root->left==NULL && root->right==NULL)
            {
                total_paths.push_back(path);
                
                
            }
                           
            if(root->left)
                pathSum(root->left,s_sum);
            if(root->right)
                pathSum(root->right,s_sum);
            
        path.pop_back();
        return total_paths;
        }
    }
};