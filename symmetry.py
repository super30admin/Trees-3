'''
Time Complexity: O(n)
Space Complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        q = deque([])
        q.append(root.left)
        q.append(root.right)
        while(len(q)>0):
            right = q.popleft()
            left = q.popleft()
            if(left or right):
                if((left and not right) or (right and not left) or (left.val!=right.val)):
                    return False
                q.append(left.left)
                q.append(right.right)
                q.append(left.right)
                q.append(right.left)
        return True



        