// Time Complexity :O(n) where n in the number of nodes in a tree
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        int count =0;
        TreeNode *t1, *t2;
        queue<TreeNode*> q;
        q.push(root->left);
        q.push(root->right);
        while(++count && !q.empty()){
            cout<<count<<" "<<q.size()<<endl;
            t1 = q.front();
            q.pop();
            t2 = q.front();
            q.pop();
            if(!t1 && !t2) continue;
            if(!t1|| !t2 || t1->val != t2->val) return false;
            if(!t1->left && !t2->right && !t1->right && !t2->left){
                continue;
            }
            q.push(t1->left);
            q.push(t2->right);
            q.push(t1->right);
            q.push(t2->left);
        }
        cout<<count<<" "<<q.size()<<endl;
        return true;
    }
};