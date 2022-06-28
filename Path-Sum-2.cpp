//Time Complexity- O(n^2)
//Space Complexity- O(n)

class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        
        vector<vector<int>> ans;
        vector<int> temp;
        helper(root,targetSum,ans,temp,0);
        return ans;
    }
    
    void helper(TreeNode* root,int sum,vector<vector<int>> &ans,vector<int> temp,int cur){
        if(root==NULL){
            return;
        }
        
        temp.push_back(root->val);
        if(root->left==NULL && root->right==NULL){
            if(root->val+cur==sum){
                ans.push_back(temp);
            }
        }
        
        helper(root->left,sum,ans,temp,cur+root->val);
        helper(root->right,sum,ans,temp,cur+root->val);
    }
};