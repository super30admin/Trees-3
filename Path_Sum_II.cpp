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
        vector<int> path;
        helper(root, 0, targetSum,path);
        return result;
    }
private: void helper(TreeNode* root, int currsum, int target, vector<int> path){
    if(root == NULL)return;
    currsum += root->val;
    path.push_back(root->val);
    if(root->left==NULL && root->right==NULL){
        if(currsum==target){
            result.push_back(path);
        }
    }
    helper(root->left,  currsum, target, path);
    helper(root->right,currsum, target, path);
    path.pop_back();

    }
};
