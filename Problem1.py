# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name:  Path Sum II

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root, targetSum, [], 0 )
        return self.result
    def helper(self, root:Optional[TreeNode], targetSum: int, path: [int], currentSum: int):
        if root == None:
            return
        currentSum += root.val
        path.append(root.val)
        
        if root.left == None and root.right == None and currentSum == targetSum:
            # print(currentSum, path, root.right, root.left)
            self.result.append(path[:])
        
        self.helper(root.left, targetSum, path, currentSum)
        self.helper(root.right, targetSum, path, currentSum)
        path.pop()


