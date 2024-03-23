# TC = O(n)   -- n is number of nodes in the tree
# SC = O(1)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def dfs(left, right):
            if left == None and right == None:
                return True
            if left == None or right == None:
                return False

            return (
                (left.val == right.val)
                and dfs(left.left, right.right)
                and dfs(left.right, right.left)
            )

        return dfs(root.left, root.right)
