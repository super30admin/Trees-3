// TC: O(N)
// SC:O(N)




class Solution {
public:    
    vector<vector<int>> ans;
    vector<vector<int>> pathSum(TreeNode* root, int target){    
        if(!root) return ans;
        vector<int>path;
        helper(root, target, path);
        return ans;
    }
    void helper(TreeNode* root, int target, vector<int>path){
        
        if(!root) return;
        if(root->val == target && !root->left && !root->right){ 
            path.push_back(root->val);
            ans.push_back(path);
            return;
        }
        path.push_back(root->val);
        helper(root->left,target-root->val, path);
        helper(root->right,target-root->val, path);

    }
    

};