// Time Complexity : O(n) n is array size(# of nodes).
// Space Complexity : O(n) size of stack in recursion.
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Perform inorder traversal and for each new visit to node add that nodes value to temporary array and total sum.
// 2. If node is leaf check if total sum == target sum if true add temporary array to final answer.
// 3. If both subtrees are visited remove that element from array which is last element.


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
    vector<vector<int>> ans;
    void path(TreeNode* t, int targetSum,int sum,vector<int> &r){
        if(t==nullptr) return;
        sum=sum+(t->val);
        r.push_back(t->val);
        if((t->left)==nullptr && (t->right)==nullptr){
            if(sum==targetSum){
                ans.push_back(r);
            }
        }
        path(t->left,targetSum,sum,r);
        path(t->right,targetSum,sum,r);
        r.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> r;
        path(root,targetSum,0,r);
        return ans;
    }
};