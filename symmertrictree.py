"Time Complexity is O(N)"
"Space Complexity is O(N)"

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        queue = deque()
        if root.left and root.right:
            queue.append(root.left)
            queue.append(root.right)
        elif root.left:
            return False
        elif root.right:
            return False

        while(queue):
            value = queue.popleft()
            value2 = queue.popleft()

            if not value and not value2:
                continue
            if not value or not value2:
                return False
            if value.val!=value2.val:
                return False

            queue.append(value.left)
            queue.append(value2.right)
            queue.append(value.right)
            queue.append(value2.left)
        return True





        