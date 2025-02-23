#include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}    
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

bool checkIsSame(TreeNode* root1, TreeNode* root2){
    if(!root1&&!root2) return true;
    if(!root1||!root2) return false;
    bool areCurrentNodesSame = root1->val==root2->val;
    bool areChildrenSame = checkIsSame(root1->left,root2->right)&&checkIsSame(root1->right,root2->left);
    return areCurrentNodesSame&&areChildrenSame;
}
bool isSymmetric(TreeNode* root) {
    return checkIsSame(root,root);
}
int main(){
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(2);
    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(4);
    root->right->left = new TreeNode(4);
    root->right->right = new TreeNode(3);
    cout<<isSymmetric(root);
    return 0;
}
// Time Complexity: O(n)
// Space Complexity: O(h)
// Input: [1,2,2,3,4,4,3]
// Output: true
// Explanation: The tree is symmetric. The left subtree is a mirror reflection of the right subtree.