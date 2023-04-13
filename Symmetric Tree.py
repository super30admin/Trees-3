# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        q = [root.left,root.right]
        # q.append()
        q = [root,root]
        while len(q) > 0:
            r1 = q.pop()
            r2 = q.pop()
            if r1 == None and r2 == None:
                continue
            if r1 == None or r2 == None:
                return False
            if r1.val != r2.val:
                return False
            q.append(r1.left)
            q.append(r2.right)
            q.append(r1.right)
            q.append(r2.left)
            
        return True
