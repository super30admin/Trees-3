/* Problem Statement:
Verified on leetcode

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

 
Note:
Bonus points if you could solve it both recursively and iteratively.

 *
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>
#include<limits.h>


/**
 * Definition for a binary tree node.
 */
 struct TreeNode {
      int val;
      struct TreeNode *left;
      struct TreeNode *right;
};

bool isSymmetric_helper(struct TreeNode* left, struct TreeNode* right) {
    /* If we have reached the place where there is no right/left subtree return from here */
    if (left == NULL && right == NULL) {
        return true;
    }
    /* We must have both subtrees existing in th tree */
    if (left == NULL || right == NULL) {
        return false;
    }
    /* If root is same, then check for the following keeping in mind about the mirror mapping */
    if (left->val == right->val) {
        return (isSymmetric_helper(left->right, right->left) && isSymmetric_helper(left->left, right->right));
    }
    return false;
}
bool isSymmetric(struct TreeNode* root){
    
    return isSymmetric_helper(root, root);

}

int main(int argc, char *argv[]) {

    struct TreeNode root;
    struct TreeNode left;
    struct TreeNode right;

    root.val = 1;
    root.left = &left;
    root.right = &right;

    left.val = 2;
    left.left = NULL;
    left.right = NULL;

    right.val = 3;
    right.left = NULL;
    right.right = NULL;

    printf("Is symmetric: %d\n",isSymmetric(&root));
}


