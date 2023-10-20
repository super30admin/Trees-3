# ## Problem2 (https://leetcode.com/problems/symmetric-tree/)
# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
from collections import deque


class Solution:
    def isSymmetric(self, root):
        flag = True
        if not root:
            return flag
        q = deque([root.left, root.right])
        while q:
            left = q.popleft()
            right = q.popleft()
            if left is None and right is None:
                continue
            if left is None or right is None:
                return False
            if left.val != right.val:
                return False
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
        return True
