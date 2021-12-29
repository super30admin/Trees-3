#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <string>

using namespace std;
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
// Time Complexity --> O(n) --> n be the number of elements in a tree
// Space Complexity --> O(n) -->n be the number of elements in a tree
public:
    bool isValid = true;
    void dfs(TreeNode* left,TreeNode* right){
        if(left == NULL && right == NULL){
            return;
        }
        if(left == NULL || right == NULL || left->val != right->val){
            isValid = false;
            return;
        }
        if(isValid){
            dfs(left->left, right->right);
            dfs(left->right,right->left);
        }

    }

    bool isSymmetric(TreeNode* root) {
        if(root == NULL){
            return true;
        }
        dfs(root->left, root->right);
        return isValid;
    }
};

/*int main() {
    string pattern = "abba";
    string s = "dog dog dog dog";
    wordPattern(pattern,s);
    return 0;
}*/
