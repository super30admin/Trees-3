// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//Approach 1: recursive

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

    bool recurse(TreeNode* left, TreeNode* right){
        //base case
        if(left == NULL and right == NULL)
            return true;
        
        //break condition
        if(left == NULL || right == NULL || left->val != right->val)
            return false;
        
        //recursive calls
        return recurse(left->left, right->right) && recurse(left->right, right->left);
    }

    bool isSymmetric(TreeNode* root) {
        if(root == NULL)
            return true;

        //the right has to match the left (mirror images)
        return recurse(root->left, root->right);
    }
};


//Approach 2: BFS iterative solution

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
        if(root == NULL) return true;
        queue<TreeNode*> q;

        //we compare left and right nodes, thus adding them to the queue
        q.push(root->left);
        q.push(root->right);

        while(!q.empty()){
            //pop the first two which would be the symmetric positions
            TreeNode* left = q.front();
            q.pop();
            TreeNode* right = q.front();
            q.pop();

            if(left == NULL && right == NULL) continue;

            if(left == NULL || right == NULL || left->val != right->val)
                return false;
            
            //push the other nodes in the next level in the order of their symmetric positions
            q.push(left->left);
            q.push(right->right);
            q.push(left->right);
            q.push(right->left);
        }
        return true;
    }
};