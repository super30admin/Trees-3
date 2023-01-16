# Time Complexity: O(N)
# Space Complexity: O(N)
# Successfull ran on leetcode

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        queue = []
        if root is None:
            return True
        queue.append(root.left)
        queue.append(root.right)
        while queue:
            left = queue.pop(0)
            right = queue.pop(0)
            if not left and not right:
                continue
            if left is None or right is None or left.val!=right.val:
                return False
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)
        return True