// Time Complexity : O(n) n is array size(# of nodes).
// Space Complexity : O(n) size of stack in recursion.
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. We will crate a recursive function passing each nodes left and right subtree.
// 2. Left nodes left element should be equal to right nodes right node.
// 3. Also check if left nodes right element == right nodes left node. Return true if both are true.


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
    vector<int> ans;
    // bool chksym(){
    //     int n=ans.size();
    //     int mid = (ans.size()-1)/2;
    //     for(int i=0;i<=mid;i++){
    //         if(ans[i]!=ans[n-1-i]){
    //             return 0;
    //         }
    //     }
    //     return 1;
    // }
    bool inordertra(TreeNode* l,TreeNode* r){
        if(l==nullptr && r==nullptr){
            return 1;
        }
        if(l==nullptr || r==nullptr){
            return 0;
        }
        if( (l->val) != (r->val) ){
            return 0;
        }
        return (inordertra(l->left,r->right) && inordertra(l->right,r->left));
    }
    int it=0;
    bool chkr(TreeNode* t){
        if(t==nullptr){
            return 1;
        }
        chkr(t->right);
        // ans.push_back(t->val);
         cout<<(t->val)<<'\n';
        if(ans[it]!=(t->val)){
            return 0;
        }
        it++;
        chkr(t->left);
        return 1;
    }
    bool isSymmetric(TreeNode* root) {
        return inordertra(root,root);
        //return chkr(root);
    }
};