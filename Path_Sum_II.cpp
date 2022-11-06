/*
Time Complexity: O(n) (n-all elements in a tree)
Space Complexity: O(h+h)(1h for recursive stack, 1h for path to be maintained:cloning of path)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/
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
    vector<vector<int>> ans;
    vector<int> path;
    int pSum;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        this->pSum=targetSum;
        pathSumRec(root);
        return ans;
    }
    void pathSumRec(TreeNode* node){
        //base 
        if(node==NULL) return;
        //recursive
        pSum-=node->val;
        path.push_back(node->val);
        if(node->left==NULL && node->right==NULL){
            if(pSum==0){
                ans.push_back(vector<int> (path));
            }
        }
        pathSumRec(node->left);
        pathSumRec(node->right);
        pSum+=node->val;
        path.pop_back();
    }
};