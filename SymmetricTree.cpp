//Time Complexity O(n)
// Space Complexity O(height of tree)(Due to recursion)
//Problem successfully executed on leetcode
//No problems faced while coading this.



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
 
class Solution {
public:
    bool isValid=true;
    bool isSymmetric(TreeNode* root) {
        if(root==NULL || (root->left ==NULL && root->right==NULL)) return true;
        
        isTreeSymmetric(root->left,root->right);
        return isValid;
    }
    
    void isTreeSymmetric(TreeNode* left, TreeNode* right)
    {
        if(left == NULL && right==NULL)
        {
            return;
        }
        if(left==NULL || right==NULL || left->val != right->val)
        {
            isValid=false;
            return;
        }
        isTreeSymmetric(left->left,right->right);
        isTreeSymmetric(left->right,right->left);
    }
};