# // Time Complexity : o(n^2) for deepcopy at every node
# // Space Complexity : o(n*height) ==> o(nlogn) for complete binary OR o(n^2) for one linked-list tree
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : o( n(deepcopy) * height)
# When using recursion in tree, space complexity is by default, o(height) because we are using stack.
#
#
# // Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []

    def pathSum(self, root: TreeNode, sum1: int) -> List[List[int]]:
        currList = []
        self.dfs(root, currList, 0, sum1)
        return self.result

    def dfs(self, node, prevList, prevSum, target):
        if not node:
            return

        # process
        currList = deepcopy(prevList)
        currList.append(node.val)
        currSum = prevSum + node.val

        if not node.left and not node.right:
            if currSum == target:
                self.result.append(currList)
            return

        self.dfs(node.left, currList, currSum, target)
        self.dfs(node.right, currList, currSum, target)