/*Check if the binary tree is symmetric by comparing its left and right subtrees for mirror symmetry.
Define a helper function isMirror to recursively check if two subtrees are mirrors of each other.
Return true if the tree is symmetric; otherwise, return false.
Time Complexity: O(N), where N is the number of nodes in the binary tree. Each node is visited once.
Space Complexity: O(H), where H is the height of the binary tree. The space complexity is determined by the recursive call stack, which is at most the height of the tree for a balanced tree.*/
#include<bits/stdc++.h>
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
    bool isSymmetric(TreeNode* root) {
        return isMirror(root, root);
    }
public:
    bool isMirror(TreeNode* t1, TreeNode* t2) {
    if (t1 == NULL && t2 == NULL) return true;
    if (t1 == NULL || t2 == NULL) return false;
    return (t1->val == t2->val)
        && isMirror(t1->right, t2->left)
        && isMirror(t1->left, t2->right);
}
};