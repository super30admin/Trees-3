// {Approach 1}
// Time Complexity : O(N * h) 
//                    ...... N is toltal number of elements in tree
//                    ...... h is height of the tree (this is for copying array at each node)
// Space Complexity : O(h) ... if we consider stack used for recursion --> O(hight of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/path-sum-ii/description/

Given the root of a binary tree and an integer targetSum, 
return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. 
A leaf is a node with no children.
*/


/*
Approach 1 : Deep copy

For each recursive call to function new copy of arr is getting created while passing to function.
That means for each node, new copy is getting created. This is called as 'Deep Copy"
*/

class Solution {
    vector<vector<int>>result;
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int>arr;
        helper(root, targetSum, 0, arr);
        return result;
    }

    void helper(TreeNode* root, int targetSum, int sum, vector<int>arr){
        if(root == nullptr) return;

        sum += root->val;
        arr.push_back(root->val);
        if(sum == targetSum && root->left == nullptr && root->right == nullptr){
            result.push_back(arr);
            return;
        }
        helper(root->left, targetSum, sum, arr);
        helper(root->right, targetSum, sum, arr);

    }
};



/*
Approach 2 : Backtracking

Instead of copying array for each recursive call, we are passing array by reference.
So that same array wiuld be used for storing the number. However, this will add all the nodes
in the array which is not desired.
In backtracking method, same array is used. After returning from each node, we are nullifying
the action done at that node. In this case, we are adding node value to the array.
While returing back, we are removing the node from the array.
*/


class Solution {
    vector<vector<int>>result;
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int>arr;
        helper(root, targetSum, 0, arr);
        return result;
    }

    void helper(TreeNode* root, int targetSum, int sum, vector<int>&arr){
        if(root == nullptr) return;

        sum += root->val;
        arr.push_back(root->val);
        if(sum == targetSum && root->left == nullptr && root->right == nullptr){
            vector<int>temp(arr);
            result.push_back(temp);
        }
        helper(root->left, targetSum, sum, arr);
        helper(root->right, targetSum, sum, arr);

        arr.pop_back();
    }
};