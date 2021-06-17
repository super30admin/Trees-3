// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    vector<vector<int>> ret_vect;
    
public:
    void sum_rec(TreeNode* root, vector<int> curr_vec, int target_sum)
    {
        if(!root)
            return;
        
        // Leaf Node Condition
        if(!root->left && !root->right)
        {
            // Add the whole root to leaf number
            int sum = root->val + accumulate(curr_vec.begin(), curr_vec.end(), 0);
            
            // Add to return vector if target sum matches
            if(sum == target_sum)
            {   
                curr_vec.push_back(root->val);
                ret_vect.push_back(curr_vec);
            }
            return;
        }
        
        vector<int> temp_vect = curr_vec;
        temp_vect.push_back(root->val);
        
        // Traverse until Leaf nodes are covered
        if(root->left)
            sum_rec(root->left, temp_vect, target_sum);
        
        if(root->right)
            sum_rec(root->right, temp_vect, target_sum);
        
        return;
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        
        vector<int> vect;

        sum_rec(root, vect, targetSum);
        
        return ret_vect;
    }
};