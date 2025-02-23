#include<bits/stdc++.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}    
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

void recurse(TreeNode* root,vector<int>&accumulatedList, int&accumulatedSum, int targetSum,vector<vector<int>>&bag){
    bool isLeaf = (!root->left&&!root->right);
    accumulatedList.push_back(root->val);
    accumulatedSum+=root->val;
    if(isLeaf){
        if(accumulatedSum==targetSum){
            bag.push_back(accumulatedList);
        }
    }
    if(root->left) recurse(root->left,accumulatedList,accumulatedSum,targetSum,bag);
    if(root->right) recurse(root->right,accumulatedList,accumulatedSum,targetSum,bag);
    accumulatedSum -=root->val;
    accumulatedList.pop_back();
}
vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
    
    vector<int>accumulatedList;
    int accumulatedSum = 0;
    vector<vector<int>>bag;
    if(!root) return bag;
    recurse(root,accumulatedList,accumulatedSum,targetSum,bag);
    return bag;
}

int main(){
    TreeNode* root = new TreeNode(5);
    root->left = new TreeNode(4);
    root->right = new TreeNode(8);
    root->left->left = new TreeNode(11);
    root->left->left->left = new TreeNode(7);
    root->left->left->right = new TreeNode(2);
    root->right->left = new TreeNode(13);
    root->right->right = new TreeNode(4);
    root->right->right->left = new TreeNode(5);
    root->right->right->right = new TreeNode(1);
    vector<vector<int>> bag = pathSum(root,22);
    for(int i=0;i<bag.size();i++){
        for(int j=0;j<bag[i].size();j++){
            cout<<bag[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}
// Time Complexity: O(n)
// Space Complexity: O(h)
// Input: [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]
// Explanation: The root-to-leaf paths 5->4->11->2 and 5->8->4->5 represent the sum 22.