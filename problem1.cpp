
// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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
    
    
    void pathSumRecur(TreeNode* root, int sum, int targetSum, vector<int>row, vector<vector<int>>&answer ){
        if( root == nullptr ){
            return;
        }
        
        sum += root->val;
        row.push_back( root->val);
        if( root->left == nullptr && root->right == nullptr && sum == targetSum ){
            answer.push_back( row );
        }
        
        pathSumRecur( root->left, sum, targetSum, row, answer );
        pathSumRecur( root->right, sum, targetSum, row, answer );
    }
    
    
    vector<vector<int>> pathSum( TreeNode* root, int targetSum ) {
        int sum = 0;
        vector<int>row;
        vector<vector<int>>answer;
        pathSumRecur( root, sum, targetSum, row, answer );
        return answer;
    }
};
