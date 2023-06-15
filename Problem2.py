'''
Problem: Symmetric Tree
Time Complexity: O(n), where n is number of nodes
Space Complexity: O(h), height of tree got recursion stack
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        compare node left to node right
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def helper(node1, node2):
            if node1 is None and node2 is None:
                return True
            
            if node1 is None or node2 is None:
                return False
            
            if node1.val == node2.val:
                return helper(node1.left, node2.right) and helper(node1.right, node2.left)
        
        return helper(root, root)