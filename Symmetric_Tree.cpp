//
//  main.cpp
//  101_Symmetric_Tree
//TC:O(N),  SC:O(h), N = NUmber of nodes in tree, h = height of tree

#include <iostream>
#include <stack>

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
    bool isSymmetric(TreeNode* root) {
        if(root == NULL) return true;
        return helper(root->left, root->right);
    }
    
    bool helper(TreeNode* leftTree, TreeNode* rightTree){
        //if both are null then return true;
        if(leftTree == NULL && rightTree == NULL)
            return true;
        //check if both left and right are available , if so, check if their values are equal if so recursively check their left child and right child
        if(leftTree && rightTree && (leftTree->val == rightTree->val)
           && helper(leftTree -> left, rightTree -> right) && helper(rightTree -> left, leftTree -> right))
        
            return true;
        else
            return false;
    }
    
    
//    bool isSymmetricIterative(TreeNode* root) {
//        stack<TreeNode*> s;
//        s.push(root);
//        s.push(root);
//        while(s.empty()==false){
//           TreeNode* node1 = s.top(); s.pop();
//           TreeNode* node2 = s.top(); s.pop();
//           if(node1 == NULL && node2 == NULL) continue;
//           if(node1 == NULL || node2 == NULL) return false;
//           if(node1->val != node2->val) return false;
//           s.push(node1->left);
//           s.push(node2->right);
//           s.push(node1->right);
//           s.push(node2->left);
//        }
//        return true;
//    }
};

int main()
{
    TreeNode *root        = new TreeNode(1);
    root->left        = new TreeNode(2);
    root->right       = new TreeNode(2);
    root->left->left  = new TreeNode(3);
    root->left->right = new TreeNode(4);
    root->right->left  = new TreeNode(4);
    root->right->right = new TreeNode(8);
    Solution s;
    cout << s.isSymmetric(root) << endl;
    return 0;
} 
