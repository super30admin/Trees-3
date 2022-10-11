# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC: O(n)
# SC: O(n)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        # bfs
        q = []
        q.append(root.left)
        q.append(root.right)

        while len(q) != 0:
            left = q.pop(0)
            right = q.pop(0)
            if left == None and right == None:
                continue
            if left == None or right == None or left.val != right.val:
                return False
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
        return True


