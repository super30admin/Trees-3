# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)
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

## Problem2 (https://leetcode.com/problems/symmetric-tree/)
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
