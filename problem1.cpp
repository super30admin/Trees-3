//Time Complexity - O(n^2)
//Space Complexity - O(h)
class Solution {
public:
    vector<vector<int>>v;
    vector<int>v1;
    void dfs(TreeNode* root, int sum){
        v1.push_back(root->val);
        sum=sum-root->val;
        if(root->left==NULL&&root->right==NULL){
            if(sum==0){
                v.push_back(v1);
            }
        }
        
        if(root->left)
            dfs(root->left,sum);
        if(root->right)
            dfs(root->right,sum);
        v1.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if(!root)
            return v;
        dfs(root,targetSum);
        return v;
    }
};