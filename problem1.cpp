/*
// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
when the node has only one null pointer


// Your code here along with comments explaining your approach
You traverse through the tree take sum of all the nodes untill leaf and check if sums to the target sum


*/

#include<iostream>
#include<vector>

using namespace std;

typedef struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode():val(0),left(nullptr),right(nullptr){};

}TreeNode;

class Solution {
public:
    void helper(TreeNode* curr,vector<int> arr,int curr_sum,int target_sum,vector<vector<int>>& res){
        if(curr == NULL){
            return;
        }
        curr_sum+= curr->val;
        arr.push_back(curr->val);
        if(curr->left == NULL && curr->right == NULL){
            if(curr_sum == target_sum){
                res.push_back(arr);
                return;
            }
        }
        helper(curr->left,arr,curr_sum,target_sum,res);
        helper(curr->right,arr,curr_sum,target_sum,res);
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> res;
        vector<int> arr;
        helper(root,arr,0,targetSum,res);
        return res;
    }
};
