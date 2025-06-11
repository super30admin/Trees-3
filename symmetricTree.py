# TC: O(n)
# SC: O(n)
from collections import deque
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q=deque([root.left,root.right])

        while q:
            left=q.popleft()
            right=q.popleft()
            if not left and not right:
                continue
            if (not left or not right) or (left.val != right.val):
                return False
            
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
        
        return True