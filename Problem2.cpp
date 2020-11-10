//
// Created by shazm on 7/24/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

// Runtime : O(N)
// Space : O(N)
// Approach : root's left and right should be equal and root->left->left should be equal to root->right->right.
// similarly, root->left->right and root->right->left should be equal. Go through the values using recursion and return false if any condition is false.
// Works on leetcode : yes

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root==NULL){return true;}
        return recurr(root->left,root->right);
    }

    bool recurr(TreeNode* Left, TreeNode* Right){
        if(Left == NULL && Right == NULL){
            return true;
        }
        if(Left!=NULL && Right != NULL && Left->val == Right->val){
            return recurr(Left->left,Right->right) && recurr(Left->right,Right->left);
        }
        return false;
    }
};