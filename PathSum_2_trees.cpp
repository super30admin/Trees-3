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

//Recursive solution
// Time Complexity : O(n)
// Space Complexity : O(h) worst case O(n).
//1. Find root and traverse complete left or rigt root through recursion
//2. Push the left path elements leaf node is encountered.
//3. Push the right path elements leaf node is encountered.

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        //edge case
        if(root == NULL){
            return result;
        }
        vector<int> temp_result;
        create_result(root, sum, 0, temp_result);
        return result;
    }
    
    void create_result(TreeNode*  root, int sum,int sum_till_node, vector<int> temp_result){
        //returning condition
        if(root == NULL){
            return;
        }
        sum_till_node = (sum_till_node)+root->val;
        temp_result.push_back(root->val);
        if(root->left == NULL && root->right == NULL &&  (sum == sum_till_node)){
            result.push_back(temp_result);
        }
        create_result(root->left, sum, sum_till_node, temp_result);
        create_result(root->right, sum, sum_till_node, temp_result);
    }
};


