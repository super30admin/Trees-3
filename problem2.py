#Time Complexity : O(n)
#Space Complexity : O(h)
#Any problem you faced while coding this : -

#This approach is to use DFS for checking the left and right subtrees and their individual nodes. If the values are equal, we recursively check and if not then we return False.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def check(self, root1, root2):
        if root1 and root2:
            if root1.val == root2.val:
                return self.check(root1.right, root2.left) and self.check(root1.left, root2.right)
            else:
                return False
        if root1 is None and root2 is None:
            return True
        return False

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.check(root.left, root.right)
    