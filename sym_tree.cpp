//TC: O(n)
//SC: O(n) where n is number of nodes in the tree

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
        
        //iterative solution
        
        if(root == NULL)
            return true;
        
        queue <TreeNode *> curr;
        curr.push(root->left);
        curr.push(root->right);
        
        while(!curr.empty()){
            
            TreeNode *node1 = curr.front();
            curr.pop();
            TreeNode *node2 = curr.front();
            curr.pop();
            
            if(!node1 && node2) return false;
            if(node1 && !node2) return false;   //done because if we use "or", then !node1 && !node2 is also 
                                                //taken as false, when it may be correct
            if(node1 && node2){
                
                if(node1->val != node2->val)
                    return false;
                
                curr.push(node1->left);
                curr.push(node2->right);
                curr.push(node1->right);
                curr.push(node2->left);
                
            }
                  
        }
        
        return true;
        
        
    }
};