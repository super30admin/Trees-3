# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC: O(n/2) as we are processing 2 nodes at a time
    SC: O(max depth of the tree)
    """

    def recurr(self, node1, node2):

        # if both the nodes are null then return true
        if node1 == None and node2 == None:
            return True

        # if either of the nodes are not null
        # and their values are not equal then return true
        if node1 == None or node2 == None or node1.val != node2.val:
            return False

        return self.recurr(node1.left, node2.right) and self.recurr(node1.right, node2.left)

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        if root == None:
            return True

        return self.recurr(root.left, root.right)
