// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. We will use a helper function that will take two nodes as input and compare the values of the left and right child of the two nodes.
// 2. If the left child of the left node is equal to the right child of the right node and the right child of the left node is equal to the left child of the right node, we will return true.
// 3. We will recursively call the helper function on the left child of the left node and the right child of the right node.

class Solution {
    private: 
        bool helper(TreeNode* left, TreeNode* right){
            if(left == nullptr && right == nullptr){return true;}
            if(left == nullptr || right == nullptr){return false;}
            if(left -> val != right -> val){return false;}
    
            return helper(left -> left, right -> right) && 
            helper(left -> right, right -> left);
        }
    public:
        bool isSymmetric(TreeNode* root) {
            if(root == nullptr){
                return false;
            }
            return helper(root -> left, root -> right);
        }
    };