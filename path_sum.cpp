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

            vector<int> ans;
            inorder(root,targetSum,0,ans);
            return result;
        
    }

    void inorder(TreeNode* root,int targetSum,int sum,vector<int> ans){
            if(root == NULL){
                return ;
            }


            sum = sum + root->val;
            ans.push_back(root->val);
            inorder(root->left,targetSum,sum,ans);
            if(root->left == NULL && root->right == NULL){
                if(targetSum == sum){
                        return result.push_back(ans);
                }
            }

        inorder(root->right,targetSum,sum,ans);


    }
};