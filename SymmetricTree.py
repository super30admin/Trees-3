# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Recursive Approach. If there is no root then return True
# If there is a left and right child of the root, then check the value of left and right node
# If the value is not same then return False else it is symmetric
# Check for the left and right value until the leaf node and if same it is symmetric
# If left or right node is missing, then it is not a symmetric tree


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.helper(root.left, root.right)

    def helper(self, node1, node2):
        if node1 == None and node2 == None:
            return True
        elif node1 == None or node2 == None:
            return False
        else:
            return node1.val == node2.val and self.helper(
                node1.left, node2.right) and self.helper(
                    node1.right, node2.left)
