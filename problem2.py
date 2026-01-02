"""
I use BFS to compare the values and conditions - whether two mirror values match each other, if both are none return True and if even one is absent or values arent equal return
False, then the other children are appended to the queue for further processing.
O(N) for time and o(height) for space (Stack)
"""
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        if not root:
            return True
        q = collections.deque()
        q.append((root.left, root.right))
        while q:
            a, b = q.popleft()
            if not a and not b:
                continue
            if not a or not b:
                return False
            if a.val != b.val:
                return False
            q.append((a.left, b.right))
            q.append((b.left, a.right))
        return True

        