# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        queue = []
        queue.append(root.left)
        queue.append(root.right)
        
        while(queue):
            left = queue.pop(0)
            right = queue.pop(0)
            if(left == None and right == None):
                continue
            if(left == None or right == None or left.val != right.val):
                return False
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)
        
        return True
        
        