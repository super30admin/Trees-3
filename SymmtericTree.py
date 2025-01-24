# Time Complexity : O(n), n is no of elements in the tree
# Space Complexity : O(h), where h is the height of the tree, since its a recursive solution, it uses stack implementation under the hood, and the no of elements in a stach at any time will at max be equal to the height of the tree (left subtree or right subtree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# recursive apporoach - depth first search
# we are diving the the tree in left subtree and right subtree
# then comparing the mirror elements
# left.left is mirror for right.right (see example in question)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def __init__(self):
        self.issym = True

    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # diving the tree in two halves
        self.dfs(root.left, root.right)
        return self.issym
    
    def dfs(self, left, right):
        # comparing left subtree with right subtree
        # base case, when we both are none (leaf node - we just return)
        if left is None and right is None:
            return
        # if one node on the other subtree is missing, the tree cannot be symmetric
        if left is None or right is None:
            self.issym = False
            return
        # if the values are separate, then also the tree cannot be symmetric
        if left.val != right.val:
            self.issym = False
            return

        # comparing mirror elements on left and right
        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)
        