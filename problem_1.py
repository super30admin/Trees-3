# BackTracking.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.result = []

    def helper(self, root, targetSum, currentSum, result):
        if root is None:
            return result
        currentSum += root.val
        result.append(root.val)
        if root.left is None and root.right is None and currentSum == targetSum:
            self.result.append(result[:])
        self.helper(root.left, targetSum, currentSum, result)
        self.helper(root.right, targetSum, currentSum, result)
        result.pop()

    def pathSum(self, root, targetSum: int) -> list[list[int]]:
        self.helper(root, targetSum, 0, [])
        return self.result


check = TreeNode(5)
check.left = TreeNode(4)
check.right = TreeNode(8)
check.left.left = TreeNode(11)
check.right.left = TreeNode(13)
check.right.right = TreeNode(4)
check.left.left.left = TreeNode(7)
check.left.left.right = TreeNode(2)
check.right.right.left = TreeNode(5)
check.right.right.right = TreeNode(1)
check1 = Solution()
print(check1.pathSum(check, 22))


# iterative.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.result = []
#         self.currSum = 0
#         self.path = []
#         self.stack = []
#
#     def pathSum(self, root, targetSum: int) -> list[list[int]]:
#         while root or self.stack:
#             while root:
#                 self.currSum += root.val
#                 self.path.append(root.val)
#                 self.stack.append([[root, 1], self.path, self.currSum])
#                 root = root.left
#             root = self.stack[-1][0][0]
#             visited = self.stack[-1][0][1]
#             self.path = self.stack[-1][1]
#             self.currSum = self.stack[-1][-1]
#             if root.right is None and root.left is None and self.currSum == targetSum and visited == 2:
#                 self.result.append(self.path[:])
#             if visited == 1:
#                 self.stack[-1][0][1] = 2
#                 root = root.right
#             else:
#                 self.path.pop()
#                 self.stack.pop()
#                 root = None
#         return self.result
#
#
# check = TreeNode(5)
# check.left = TreeNode(4)
# check.right = TreeNode(8)
# check.left.left = TreeNode(11)
# check.right.left = TreeNode(13)
# check.right.right = TreeNode(4)
# check.left.left.left = TreeNode(7)
# check.left.left.right = TreeNode(2)
# check.right.right.left = TreeNode(5)
# check.right.right.right = TreeNode(1)
# check1 = Solution()
# print(check1.pathSum(check, 22))


# # TC - O(n*n); SC - O(n*n)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.result = []
#
#     def helper(self, root, targetSum, currentSum, result):
#         if root is None:
#             return result
#         currentSum += root.val
#         result.append(root.val)
#         if root.left is None and root.right is None and currentSum == targetSum:
#             self.result.append(result)
#         self.helper(root.left, targetSum, currentSum, result[:])
#         self.helper(root.right, targetSum, currentSum, result[:])
#
#     def pathSum(self, root, targetSum: int) -> list[list[int]]:
#         self.helper(root, targetSum, 0, [])
#         return self.result
#
#
# check = TreeNode(5)
# check.left = TreeNode(4)
# check.right = TreeNode(8)
# check.left.left = TreeNode(11)
# check.right.left = TreeNode(13)
# check.right.right = TreeNode(4)
# check.left.left.left = TreeNode(7)
# check.left.left.right = TreeNode(2)
# check.right.right.left = TreeNode(5)
# check.right.right.right = TreeNode(1)
# check1 = Solution()
# print(check1.pathSum(check, 22))
