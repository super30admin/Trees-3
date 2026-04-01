# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use BFS with a queue to compare nodes in pairs.
# Start by pushing the root twice.
# At each step, pop two nodes and compare them.
# If both are null, continue. If only one is null or values differ, return False.
# Push children in mirrored order: (left.left, right.right) and (left.right, right.left).
# If all pairs match, the tree is symmetric.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q = deque()
        q.append(root)
        q.append(root)

        while q:
            left = q.popleft()
            right = q.popleft()

            if left == None and right == None:
                continue
            if left != None and right == None:
                return False
            if left == None and right != None:
                return False
            if left.val != right.val:
                return False
            
            q.append(left.left)
            q.append(right.right)

            q.append(left.right)
            q.append(right.left)
        
        return True
