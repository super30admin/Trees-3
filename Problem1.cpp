/*
Time Complexity : O(n). Covers each node of the tree once.
Space Complexity : O(n) Stores the nodes in the array.
Did it run on LeetCode : Yes
Any problems faced? 
	- Could develop the recursive algorithm on paper for the question. Took a little help online to code the solution.

*/

#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    void pathSum(TreeNode* root, int sum,vector<vector<int>>& vectorMain, vector<int>& vector2){
        if(!root) return ;
        sum= sum-root->val; // When a node is considered, Value is subtracted from required sum.
        vector2.push_back(root->val);   // the node is then pushed to the array(vector).
        if(!root->left && !root->right){    // If nodes are not null, and sum is 0, push the array of arrays of nodes.
            if(sum == 0) vectorMain.push_back(vector2);

        }
        pathSum(root->left, sum, vectorMain, vector2); // recursively call function for left and right side.
        pathSum(root->right, sum, vectorMain, vector2);
        vector2.pop_back(); // The vector is then popped back if required sum is not achieved.
    }

    vector<vector<int>> pathSum(TreeNode* root, int sum) {

        vector<vector<int>> vec;
        vector<int> v;
        pathSum(root ,sum, vec, v);
        return vec;

    }
};