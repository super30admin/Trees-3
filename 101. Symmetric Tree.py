"""
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
 

Follow up: Solve it both recursively and iteratively.
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.check_mirror(root, root)
    

    def check_mirror(self, root1, root2):
        if root1 is None and root2 is None:
            return 1
        if root1 is None or root2 is None:
            return 0
        
        
        return (root1.val == root2.val) and  self.check_mirror(root1.left, root2.right) and self.check_mirror(root1.right, root2.left)