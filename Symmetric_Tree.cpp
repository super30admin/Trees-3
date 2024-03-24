// {Approach 1}
// Time Complexity : O(n) ...... N is toltal number of elements in tree
// Space Complexity : O(n) ..... extra space used for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/symmetric-tree/description/

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
*/

/**
 * Explaination : 
 * A queue is used to push two nodes at a time.
 * In each pass these tow nodes are checked for their values.
 * 
 * Also, addition of new elements in the ques is important here. They are added in mirror
 * image pattern of left and right side.
*/

class Solution {

public:
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        q.push(root);

        while(!q.empty()){
            TreeNode* left = q.front();
            q.pop();
            TreeNode* right = q.front();
            q.pop();

            if(left == nullptr && right == nullptr) continue;
            if(left == nullptr || right == nullptr) return false;

            if(left->val != right->val) return false;
            q.push(left->left);
            q.push(right->right);
            q.push(left->right);
            q.push(right->left);
        }

        return true;
    }
};