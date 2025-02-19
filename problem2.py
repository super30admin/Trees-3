'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q = collections.deque()
        if not root: return True
        q.append(root.left)
        q.append(root.right)
        while q:
            left = q.popleft()
            right = q.popleft()
            if not left and not right:
                continue
            if not left or not right or left.val != right.val:
                return False
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
        return True

    # DFS
    # def isSymmetric(self, root: Optional[TreeNode]) -> bool:
    #     flag = True
    #     if not root: return flag

    #     def dfs(left, right):
    #         nonlocal flag
    #         if not left and not right:
    #             return
    #         if not left or not right or left.val != right.val:
    #             flag = False
    #             return
    #         dfs(left.left, right.right)
    #         dfs(left.right, right.left)

    #     dfs(root.left, root.right)
    #     return flag