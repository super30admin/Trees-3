/* Problem Statement:
Verified on leetcode

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

 *
 * Time Complexity : O(n)
 * Space Complexity : O(n)
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

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
#define MIN_ALLOC 2

void add_to_list(int ***final_arr, int *returnSize, int **returnColumnSizes, int *path, int pathsize) {
    int idx = 0;
    int *path_data = NULL;
    int **temp_final_arr = NULL;
    int *ret_col = NULL;
    
    if (!(*final_arr)) {
        *final_arr = (int **)malloc(sizeof(int *) * MIN_ALLOC);
    }
    if ( (*returnSize != 0) && (*returnSize % MIN_ALLOC) == 0) {
        *final_arr = (int **)realloc(*final_arr, sizeof(int *) * (2*MIN_ALLOC * (*returnSize / MIN_ALLOC)));
        
        *returnColumnSizes = (int *)realloc(*returnColumnSizes, sizeof(int) * (2*MIN_ALLOC * (*returnSize / MIN_ALLOC)));
    }
    temp_final_arr = *final_arr;
    ret_col = *returnColumnSizes;
    
    if (pathsize == 0) {
        return;
    }
    
    /* Copy the trace path data to newly allocated memory */
    path_data = (int *)malloc(sizeof(int) * (pathsize));
    
    for (idx = 0; idx < pathsize; idx++) {
        path_data[idx] = path[idx]; 
    }
    /* assign it to 2d array */
    temp_final_arr[*returnSize] = path_data;
    /* assign length of this result array to ret_col */
    ret_col[*returnSize] = pathsize;
    /* increment size*/
    *returnSize = *returnSize + 1;
    return;
}

void sumNumbers_helper(struct TreeNode* root, int sum, int *returnSize,
                          int **returnColumnSizes, int *path, int *pathsize, int ***final_arr) {
    /* Root is NULL, reached the end */
    if (root == NULL) {
        return;
    }
    /* memory allocation for path tracking */
    if (!path) {
        path = (int *)calloc(1, sizeof(int) * 900 *MIN_ALLOC);
    }
    /* store current root val in path */
    path[(*pathsize)] = root->val;
    *pathsize = *pathsize + 1;
    
    /* We have reached leaf node, so if we have reached a valid path the left sum should be equal to root value */
    if (root->left == NULL && root->right == NULL && sum == root->val) {
        add_to_list(final_arr, returnSize, returnColumnSizes, path, *pathsize);
        return;
    }
    
    /* If left subtree is present, call it with sum subtracted with root value */
    if (root->left != NULL) {
        sumNumbers_helper(root->left, sum - root->val, returnSize, returnColumnSizes, path, pathsize, final_arr);
        path[(*pathsize)--] = 0;
    }
    
    /* for right subtree */
    if (root->right != NULL) {
        sumNumbers_helper(root->right, sum - root->val, returnSize, returnColumnSizes, path, pathsize, final_arr);
       path[(*pathsize)--] = 0;

    }
}


int** pathSum(struct TreeNode* root, int sum, int* returnSize, int** returnColumnSizes){
    
    int *path = NULL;
    int pathsize = 0;
    int **final_arr = NULL;
    
    /* initialize with 0 */
    *returnSize = 0;
    /* allocate memory for return column sizes */
    *returnColumnSizes = (int *)calloc(1, sizeof(int) * (MIN_ALLOC));
    /* call helper function to do the tasks */
    sumNumbers_helper(root, sum, returnSize, returnColumnSizes, path, &pathsize, &final_arr);

    return final_arr;
}


/* Execute it on leetcode*/

