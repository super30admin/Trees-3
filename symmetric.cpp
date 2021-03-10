// TC: O(N) where N is the no of nodes in the tree
// SC: O(N) where N is the no of nodes in the tree


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
        queue<TreeNode*>q;
        if(root == NULL)return true;
        q.push(root->left);
        q.push(root->right);
        while(!q.empty()){
            TreeNode* t1 = q.front();q.pop();
            TreeNode* t2 = q.front();q.pop();
            if(t1 == NULL && t2==NULL)continue;
            if(t1==NULL || t2 ==NULL)return false;
            if(t1->val != t2->val)return false;
            q.push(t1->left);
            q.push(t2->right);
            q.push(t1->right);
            q.push(t2->left);
            
        }
        return true;
     
        
  
        
        

        
    }

};