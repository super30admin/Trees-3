# Did it run successfully on LC? YES

from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root) -> bool:
        if not root:
            return True
        queue = deque()
        queue.append(root)
        queue.append(root)
        while queue:
            # for _ in range(len(queue)):
            node1 = queue.popleft()
            node2 = queue.popleft()
            if not node1 and not node2:
                continue
            if node1 is None or node2 is None:
                return False
            if node1.val != node2.val:
                return False

            queue.append(node1.left)
            queue.append(node2.right)
            queue.append(node1.right)
            queue.append(node2.left)
        return True
    
if __name__ == "__main__":
    s = Solution()
    root = [1,2,2,3,4,4,3]
    print(s.isSymmetric(root))