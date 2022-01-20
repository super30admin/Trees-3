/*
Time Complexity:
O(N) as we are traversing the tree only once
*/


/*
Space Complexity:
O(H) where H is the height of the tree
*/

/*
Approach:
We can have both recursive and iterative solution.
Time and space complexity will be same in both the cases, but
recursive easier to implement. 

To get a symmetric tree we should be seeing the left and the right subtree 
as each others mirror images. The left child of the left subtree
should be equal to the right child of the right subtree and the right
child of the left subtree should be equal to to the left child of the
right subtree.

Based on this logic we can find if it is symmetric or not.
 */

// The code ran perfectly on leetcode.





class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root== NULL) {
            return true;
        }
        return helper(root->left, root->right);
    }
    
    private:
    bool helper(TreeNode*left, TreeNode*right){
        //base
        if(left == NULL && right == NULL) return true;
        if(left == NULL || right == NULL) return false;
        if(left->val != right->val) return false;
        //logic
        return helper(left->left, right->right) && helper(left->right, right->left);
        
    }
};