# Time Complexity : O(n) where n is the number of integers present in list
# Space Complexity : O(n) to store the keys
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:

        self.target = sum

        self.finalSum = []

        if root == None: return self.finalSum

        self.dfs(root, 0, [])

        return self.finalSum

    def dfs(self, root, currentSum, temp):

        if root == None: return

        currentSum += root.val

        temp.append(root.val)

        if root.left == None and root.right == None:

            if currentSum == self.target:
                self.finalSum.append(temp)

        self.dfs(root.left, currentSum, temp.copy())

        self.dfs(root.right, currentSum, temp.copy())

        return













