# Time Complexity :O(n^2) where n is number of nodes in the tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    global target
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:

        self.res = []
        temp = []
        global target
        target = sum
        if root is None:
            return self.res
        self.dfs(root, 0, temp)
        return self.res

    def dfs(self, root, currSum, temp):

        if root is None:
            return

        currSum += root.val

        temp.append(root.val)

        if root.left == None and root.right == None:
            if target == currSum:
                self.res.append(temp)

        # create an empty array and then add elements
        temp1 = temp.copy()
        temp2 = temp.copy()

        self.dfs(root.left, currSum, temp1)
        self.dfs(root.right, currSum, temp2)
