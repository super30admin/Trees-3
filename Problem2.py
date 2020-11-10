# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def isSymmetric(self, root):
		# left part of first tree must be same as the right part of the second tree
		# right part of first tree must be same as the left part of the second tree
		return self.helper(root, root)

	def helper(self, node1, node2):
		if node1 == None and node2 == None:
			# If both the trees are none then they are symmetrix
			return True
		if node1 == None or node2 == None:
			# If one of them is None and other is not none then they are not symmetric
			return False
		# Finally check for the value at the current node for both the tree nodes and compare the left with right and right with left
		return (node1.val == node2.val) and self.helper(node1.left, node2.right) and self.helper(node1.right, node2.left)