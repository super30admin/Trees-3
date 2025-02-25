"""
## Problem2 (https://leetcode.com/problems/symmetric-tree/)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC: O(n)
#SC: O(n)

# iterative aaproach

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        dq = collections.deque([root.left, root.right])
        
    
        while dq:
            treeLeft = dq.pop()
            treeRight = dq.pop()
            if treeLeft is None and treeRight is None: continue
            if treeLeft is None or treeRight is None: return False
            if treeLeft.val != treeRight.val: return False
            
            dq.append(treeLeft.left)
            dq.append(treeRight.right)
            dq.append(treeLeft.right)
            dq.append(treeRight.left)

        return True

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursive aaproch

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
       def helper(t1, t2):
            if t1 is None and t2 is None: return True
            if t1 is None or t2 is None : return False
            return (
                (t1.val == t2.val)
                and helper(t1.right, t2.left) 
                and helper(t1.left, t2.right)
            )

       return helper(root, root)

