// Time Complexity : O(N) where N is the number of nodes in the tree
// Space Complexity : O(H) where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/path-sum-ii/
// Submission Link: https://leetcode.com/submissions/detail/537655741/

class Solution {
    vector<vector<int> > ans;
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        
        vector<int> cur;
        helper(root, targetSum, cur);
        
        return ans;
    }
    
    void helper(TreeNode* root, int remSum, vector<int>& cur){
        if(root == NULL)
            return;
        
        cur.push_back(root -> val);
        
        if(remSum == root -> val && root -> left == NULL && root -> right == NULL){
            ans.push_back(cur);
        }
        
        helper(root -> left, remSum - root -> val, cur);
        helper(root -> right, remSum - root -> val, cur);
        cur.pop_back();
    }
};