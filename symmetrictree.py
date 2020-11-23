# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time complexity - O(n)
# Space complexity - O(2h) recursive stack
# Did this solution run on leetcode? - yes
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
    
        def symmetry(node1: TreeNode, node2: TreeNode):
            if not (node1 or node2):
                return True
            elif not node1 or not node2:
                return False
            return (node1.val == node2.val) and symmetry(node1.left, node2.right) and symmetry(node1.right, node2.left)
    
        return symmetry(root, root)


# Time complexity - O(n)
# Space complexity - O(2h) iteration 
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:    
        nodeq = deque()
        nodeq.append(root)
        nodeq.append(root)
        
        while nodeq:
            node1, node2 = nodeq.popleft(), nodeq.popleft()
            if not (node1 or node2):
                continue
            elif not node1 or not node2 or node1.val!=node2.val:
                return False
            nodeq.append(node1.left)
            nodeq.append(node2.right)
            nodeq.append(node1.right) 
            nodeq.append(node2.left)
                
        return True