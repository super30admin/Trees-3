# DFS iterative
# Time Complexity : O(n)
# Space Complexity : O(h);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root) -> bool:
        stack = [root.left, root.right]
        while stack:
            right = stack.pop()
            left = stack.pop()
            if not left and not right:
                continue
            if left is None or right is None or right.val != left.val:
                return False
            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)
        return True


check = TreeNode(1)
check.left = TreeNode(2)
check.right = TreeNode(2)
check.left.left = TreeNode(3)
check.left.right = TreeNode(4)
check.right.left = TreeNode(4)
check.right.right = TreeNode(3)
print(Solution().isSymmetric(check))


# DFS recursive
# TC: O(n); SC: O(h)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.flag = True

#     def dfs(self, left, right):
#         if left is None and right is None:
#             return
#         if left is None or right is None or left.val != right.val:
#             self.flag = False
#             return
#         self.dfs(left.left, right.right)
#         self.dfs(left.right, right.left)

#     def isSymmetric(self, root) -> bool:
#         self.dfs(root.left, root.right)
#         return self.flag
#
#
# check = TreeNode(1)
# check.left = TreeNode(2)
# check.right = TreeNode(2)
# check.left.left = TreeNode(3)
# check.left.right = TreeNode(4)
# check.right.left = TreeNode(4)
# check.right.right = TreeNode(3)
# print(Solution().isSymmetric(check))

# BFS
# TC: O(n); SC: O(n)
# from collections import deque
#
#
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def isSymmetric(self, root) -> bool:
#         queue = deque()
#         queue.append(root.left)
#         queue.append(root.right)
#         while queue:
#             left = queue.popleft()
#             right = queue.popleft()
#             if left == None and right == None:
#                 continue
#             if left == None or right == None or left.val != right.val:
#                 return False
#             queue.append(left.left)
#             queue.append(right.right)
#             queue.append(left.right)
#             queue.append(right.left)
#         return True
#
#
# check = TreeNode(1)
# check.left = TreeNode(2)
# check.right = TreeNode(2)
# check.left.left = TreeNode(3)
# check.left.right = TreeNode(4)
# check.right.left = TreeNode(4)
# check.right.right = TreeNode(3)
# print(Solution().isSymmetric(check))


# TC: O(n^2); SC: O(n)
# from collections import deque
#
#
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def isSymmetric(self, root) -> bool:
#         queue = deque()
#         queue.append(root)
#         while queue:
#             size = len(queue)
#             start = 0
#             end = len(queue) - 1
#             while start <= end:
#                 if queue[start].val != queue[end].val:
#                     return False
#                 start += 1
#                 end -= 1
#             for i in range(size):
#                 pop = queue.popleft()
#                 if pop.val != -101:
#                     if pop.left:
#                         queue.append(pop.left)
#                     else:
#                         queue.append(TreeNode(-101))
#                     if pop.right:
#                         queue.append(pop.right)
#                     else:
#                         queue.append(TreeNode(-101))
#         return True
#
#
# check = TreeNode(1)
# check.left = TreeNode(2)
# check.right = TreeNode(2)
# check.left.left = TreeNode(3)
# check.left.right = TreeNode(4)
# check.right.left = TreeNode(4)
# check.right.right = TreeNode(3)
# print(Solution().isSymmetric(check))
