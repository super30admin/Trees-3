#Time Complexity: O(n)
#Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q = deque()
        q.append(root.left)
        q.append(root.right)
        
        while q:
            left = q.popleft()
            right = q.popleft()
            if left is None and right is None:
                continue
            if left is None or right is None or left.val != right.val:
                return False
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
                
        return True
