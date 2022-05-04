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
//time complexity : o(n)
//space com: o(h)
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        
        if(root == NULL) return true;
        
        return helper(root->left,root->right);
    }
    
   bool helper(TreeNode *rootLeft,TreeNode *rootRight) {
      
       if(rootLeft == NULL && rootRight == NULL) return true;
       
        if(rootLeft == NULL || rootRight == NULL || rootLeft->val != rootRight->val) {
            return false;
        }
            
         bool case1 = helper(rootLeft->left,rootRight->right);
         bool case2 =  helper(rootLeft->right,rootRight->left);
           
           return case1 &&case2;
   }
    
};