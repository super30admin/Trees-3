//Included 2 solutions
// Time Complexity : O(hn)
// Space Complexity :O(hn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

/*
In the first solution brute force, we will be creating deep copies of the path formed at every
single node to tackle the problem caused by passing by reference. We will be creating deep
copies after each recursive call  so that the paths can be store into the result without 
worrying about the vector changing its values as it continues to traverse through the tree
*/


// Your code here along with comments explaining your approach
#include <iostream>
#include <vector>

using namespace std;

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
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> list;
        helper(root,targetSum,0,list);
        return result;
        
        
    }

    void helper(TreeNode* root, int targetSum, int currSum, vector<int>& path){

        if(root==NULL){
            return;
        }

        currSum+=root->val;
        vector<int> li = path;
        li.push_back(root->val);
        if(root->left==NULL && root->right==NULL){
            if(currSum == targetSum){
                
                result.push_back(li);
            }
        }

        helper(root->left,targetSum,currSum,li);
        helper(root->right,targetSum,currSum,li);

         

    }
};

//Included 2 solutions
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

/*
We will be using backtracking in this solution, so after the left and right children are traversed we will
be reducing the size i.e remove the last element of the path and if the path of the root to leaf
matches the target a new vector will be created to tackle passing by reference otherwise the result will
form 2 empty paths inside the result. This empty path will contain the target path and wont
be affected by future traversal of the tree.
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
    vector<vector<int>> result;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> list;
        helper(root,targetSum,0,list);
        return result;
        
        
    }

    void helper(TreeNode* root, int targetSum, int currSum, vector<int>& path){

        if(root==NULL){
            return;
        }

        currSum+=root->val;
        path.push_back(root->val);
        
        if(root->left==NULL && root->right==NULL){
            if(currSum == targetSum){
                vector<int> li = path;
                result.push_back(li);
            }
        }

        helper(root->left,targetSum,currSum,path);
        helper(root->right,targetSum,currSum,path);
        path.pop_back();

         

    }
};