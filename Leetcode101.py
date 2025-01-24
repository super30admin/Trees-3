# Time Complexity = O(n)
# Space Complexity = O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, root)

    def helper(self, node1, node2):
        if node1 == None and node2 == None:
			# If both the trees are none then they are symmetric
            return True
        if node1 == None or node2 == None:
			# If one of them is None and other is not none then they are not symmetric
            return False
		# Finally check for the value at the current node for both the tree nodes and 
        #compare the left with right and right with left
        comp1 = self.helper(node1.left, node2.right)
        comp2 = self.helper(node1.right, node2.left)
        return (node1.val == node2.val) and comp1 and comp2