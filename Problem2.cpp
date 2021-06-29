// Time Complexity : O(n^2) for Iterative, O(n) for recursive 
// Space Complexity : O(n) use of external queue and result array for Iterative, O(n) System stack for recursive
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Symmetric Tree


#include<iostream>
#include<queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


// ITERATIVE

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        
        if(root == NULL || (root->left == NULL && root->right == NULL)) { 
            return true;
        } 
        
        queue<TreeNode*> q1;
        q1.push(root);
        vector<int> res;
        
        while(!q1.empty()){
            
            int listSize = q1.size();

            
            while(listSize > 0){
                if(q1.front()){
                    q1.push(q1.front()->left);
                    q1.push(q1.front()->right);
                    res.push_back(q1.front()->val);
                }
                else{
                    res.push_back(-1);
                }
                q1.pop();
                listSize--;
            }

            int start = 0;
            int end = res.size() - 1;
            while(start < end){
                if(res[start] == res[end]){
                    ++start;
                    --end;
                }
                else{
                    return false;
                }
            }
            
            res.clear();
        }
        return true;
        
    }
};

//RECURSIVE

class Solution {
private:
    bool flag;
public:
    bool isSymmetric(TreeNode* root) {
        
        flag = true;
        SymmetricTree(root, root);
        return flag;
    }
    
    void SymmetricTree(TreeNode* t1, TreeNode* t2){
        
        if(t1 == NULL && t2 == NULL)    // BASE CASE, GO BACK IF NULL
            return;
        
        if(t1 == NULL && t2 != NULL){
            flag = false;
            return;
        }
        
        if(t2 == NULL && t1 != NULL){
            flag = false;
            return;
        }
            
        
        if(t1->val == t2->val){
            SymmetricTree(t1->left, t2->right);
            SymmetricTree(t1->right, t2->left);
        }
        else{
            flag = false;
            return;
        }
    }
};