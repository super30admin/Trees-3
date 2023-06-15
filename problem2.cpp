/*

// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :
Some trees can have same preorder to counter that use a different approach

// Your code here along with comments explaining your approach
You can use a preorder but it might fail for a certain example [1,2,2,2,NULL,2]
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
    bool isSymmetric(TreeNode* left, TreeNode*right){
        //check if left and right are empty
        if(left == NULL && right == NULL) return true;
        // if only one of them is empty return false
        if(left == NULL || right == NULL) return false;
        // first check value then check left with right and then check right with left
        // it automatically stops executing the further tree if error occurs by considering what first becomes true.
        //checking root left with right and right with left
        return (left->val == right->val) && isSymmetric(left->left,right->right)
                                        && isSymmetric(left->right,right->left);
    }
    bool isSymmetric(TreeNode* root) {
        return isSymmetric(root->left,root->right);
    }
};

// This code below doesnt work if both the trees have same inorder traversal but have different shape due to null,
// same inorder due to same value

class Solution_1{
    vector<int> a1;
    vector<int> a2;

    void display(vector<int>& arr){
        for(auto const &i:arr){
            cout<<i<<" ";
        }
        cout<<endl;
    }

public:
    void inorder_1(TreeNode* root){
        if(root == NULL){
            a1.push_back(-101);
            return;
        }
        inorder_1(root->left);
        a1.push_back(root->val);
        inorder_1(root->right);
    }
    void inorder_2(TreeNode* root){
        if(root == NULL){
            a2.push_back(-101);
            return;
        }
        inorder_2(root->right);
        a2.push_back(root->val);
        inorder_2(root->left);
    }
    bool isSymmetric(TreeNode* root) {
        if(root->left == NULL && root->right == NULL) return true;
        inorder_1(root->left);
        inorder_2(root->right);
        display(a1);
        display(a2);
        if(a1 != a2) return false;
        return true;
        
    }
};