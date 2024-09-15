"""
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


"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        return self.dfs(root.left, root.right)

    def dfs(self, leftC, rightC):
        if leftC == None and rightC == None:
            return True

        if leftC == None or rightC == None or leftC.val != rightC.val:
            return False

        left = self.dfs(leftC.left, rightC.right)
        right = self.dfs(leftC.right, rightC.left)
        return left and right











