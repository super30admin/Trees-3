""""// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def __init__(self):
        self.result = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root, targetSum, [], 0)
        return self.result

    def helper(self, root, targetSum, path, currSum):
        # base
        if not root:
            return

        # logic
        # Action
        currSum += root.val
        path.append(root.val)

        # Recursion
        self.helper(root.left, targetSum, path, currSum)

        if not root.left and not root.right:
            if currSum == targetSum:
                self.result.append(path[:])

        self.helper(root.right, targetSum, path, currSum)

        # Backtrack
        path.pop()
# Iterative-
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         currSum=0
#         path=[]
#         st=[]

#         while root!=None or st:
#             while root!=None:
#                 currSum+=root.val
#                 path.append(root.val)
#                 st.append([[root, 'f'], path, currSum])
#                 st.append([[root, 's'], path, currSum])
#                 root=root.left
#             x = st.pop()
#             root = x[0][0]
#             check = x[0][1]
#             path = x[1]
#             currSum = x[2]
#             if root.left is None and root.right is None and currSum == targetSum and check == 's':
#                 self.result.append(path[:])
#             if check == 's':
#                 root = root.right
#                 st[-1][0][1] = 'f'
#             elif check == 'f':
#                 path.pop()
#                 root = None
#         return self.result


# Time Comp-O(n*2)
# Space Comp-O(n*2) because we are creating new list at every node
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         self.helper(root, targetSum, [], 0)
#         return self.result
#     def helper(self, root, targetSum, path, currSum):
#         #base
#         if not root:
#             return

#         #logic
#         currSum+=root.val
#         path.append(root.val)

#         self.helper(root.left, targetSum, path[:] ,currSum)

#         if not root.left and not root.right:
#             if currSum==targetSum:
#                 self.result.append(path)

#         self.helper(root.right, targetSum, path[:] ,currSum)


# It wont work because of linkelist reference concept(we should not use one data structure in other)
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         self.helper(root, targetSum, [], 0)
#         return self.result
#     def helper(self, root, targetSum, path, currSum):
#         #base
#         if not root:
#             return

#         #logic
#         currSum+=root.val
#         path.append(root.val)

#         self.helper(root.left, targetSum, path ,currSum)

#         if not root.left and not root.right:
#             if currSum==targetSum:
#                 self.result.append(path)

#         self.helper(root.right, targetSum, path,currSum)
