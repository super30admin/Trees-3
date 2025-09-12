# Time Complexity : O(n)
# Space Complexity : O(n) recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Have result as a global variable and currVal and currList as a parameter to store curr total and the list of node elements
# and when its the leaf and if curr val is equal to target sum then append curr list to the result.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root, targetSum, 0, [])
        return self.result

    def helper(self, root, targetSum, currVal, currList):
        if not root:
            return None

        currVal += root.val
        currList.append(root.val)
        if (root.left is None and root.right is None and currVal == targetSum):
            self.result.append(currList.copy())

        self.helper(root.left, targetSum, currVal, currList)
        self.helper(root.right, targetSum, currVal, currList)
        currList.pop()




