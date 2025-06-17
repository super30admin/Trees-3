//Time and Space Complexity : O(n)

#include<iostream>
#include<vector>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };


// We use recursion to check if the left and right subtrees are mirror images.

// At each step, we compare the current node values.

// We recursively compare the left child of one subtree with the right child of the other, and vice versa.

// If all mirrored node pairs match, the tree is symmetric.

class Solution {
public:
   vector<int>arr;
    bool check(TreeNode* p,TreeNode* q){
        if(p==nullptr && q==nullptr)  
            return true;
        if(p==nullptr||q==nullptr)
            return false;  
        return p->val==q->val && check(p->left,q->right) && check(p->right,q->left);
    }
    bool isSymmetric(TreeNode* root) {
        if(root == nullptr)
            return true;
        return check(root->left,root->right);
    }
};