# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity O(N) where N is number of nodes in the tree
# Space complexity O(H) where H is height of the tree
class Solution(object):
    def check(self, left, right):
        stack = []
        stack.append((left, right))
        
        while stack:
            left_node, right_node = stack.pop()
            if left_node is None and right_node is None:
                continue
            elif left_node is None or right_node is None or left_node.val != right_node.val:
                return False
            stack.append((left_node.left, right_node.right))
            stack.append((left_node.right, right_node.left))
        
        return True