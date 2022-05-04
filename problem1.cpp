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
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int>path;
        helper(root,targetSum,0,path);
       return result;
    }
    
    void helper(TreeNode* root,int targetSum,int currentSum,vector<int> path) {
        
        if(root == NULL) return;
        
      currentSum = currentSum + root->val;
      path.push_back(root->val);
          if(root->left == NULL && root->right == NULL) {
            if(targetSum == currentSum) {
                result.push_back(path);
            }
        }
        //cout<<root->val;
        helper(root->left,targetSum,currentSum,path);
        helper(root->right,targetSum,currentSum,path);
    }
};