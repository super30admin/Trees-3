# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def helper(self, rootA: TreeNode, rootB: TreeNode) -> bool:
        if rootA == None and rootB == None:
            return True

        if rootA == None or rootB == None:
            return False

        return (rootA.val == rootB.val) and self.helper(rootA.left, rootB.right) and self.helper(rootA.right,
                                                                                                 rootB.left)

    def isSymmetric(self, root: TreeNode) -> bool:
        rootB = root
        return self.helper(root, rootB)