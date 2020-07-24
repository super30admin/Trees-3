// Time Complexity : O(N*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Recursion

class Solution {
public:
    vector<vector<int>> res;
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
       vector<int> tempres; 
       helper(root,tempres,sum);
       return res; 
    }
     void helper(TreeNode* root, vector<int>& tempres, int tempsum){
         
         //base case
         if(root==NULL){
             return;
         }
         tempsum = tempsum - root->val;
         tempres.push_back(root->val);
         if(root->left==NULL && root->right==NULL){
             if(tempsum == 0){
                 res.push_back(tempres);
             }
         }
         helper(root->left,tempres,tempsum);
         helper(root->right,tempres,tempsum);
         
         tempres.pop_back();
        }
};
