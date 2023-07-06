// Time Complexity : O(2^h) h->logn 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        return helper(root, root);
    }

private:
    bool helper(TreeNode* left, TreeNode* right) {
        if (left == nullptr && right == nullptr)
            return true;
        if (left == nullptr || right == nullptr || left->val != right->val)
            return false;
        return helper(left->left, right->right) && helper(left->right, right->left);
    }
};