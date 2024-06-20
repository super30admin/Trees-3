# Time Complexity : O(n)

# space complexity : O(h)

# Approach :

# use dfs
# keep two list, one final list and one which keeps get updated.
# keep adding up the sum using sum + root.val, where sum is the previous sum of the nodes .
# if a root-leaf node path is not givng the sum, pop the last element and check another.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.target = targetSum
        self.final = []

        self.checkTree(root, 0, [])

        return self.final

    def checkTree(self, root, sumVal, path):

        if root is None:
            return None

        path.append(root.val)

        if (root.left == None and root.right == None) and (sumVal + root.val == self.target):
            self.final.append(list(path))

        self.checkTree(root.left, sumVal + root.val, path)
        self.checkTree(root.right, sumVal + root.val, path)

        path.pop()
