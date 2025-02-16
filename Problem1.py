# 113. Path Sum II

# Time Complexity: O(n^2)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Intuition:
# Use DFS to traverse the tree and check if the path sum is equal to the target sum.
# Use a helper function to pass the current sum, the current path, and the target sum.
# If the node is a leaf, check if the current sum is equal to the target sum.
# Otherwise, continue the traversal.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []

        def pathSum(root, curr, arr, target):
            nonlocal result

            if root == None:
                return False

            curr += root.val
            a = [*arr, root.val]
            
            if root.left == None and root.right == None:
                if curr == target:
                    result.append(a)
                return 

            pathSum(root.left, curr, a, target)
            pathSum(root.right, curr, a, target)

        pathSum(root, 0, [], targetSum)

        return result
    
# Better Solution:

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []

        def dfs(root, path, targetSum):
            if not root:
                return
            path.append(root.val)

            if not root.left and not root.right and targetSum == root.val:
                res.append(path[:])
            
            dfs(root.left, path, targetSum - root.val)
            dfs(root.right, path, targetSum - root.val)
            path.pop()
        
        dfs(root, [], targetSum)
        return res