"""
## Problem1 (https://leetcode.com/problems/path-sum-ii/)
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


#TC: O(n)
#SC: O(n)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def helper(root, pathsum, path, targetsum):
            nonlocal result
            #base condition
            if root is None: return 


            #logic
            pathsum = pathsum + root.val
            path.append(root.val)
            
            if root.left is None and root.right is None and targetsum == pathsum:
                result.append(list(path))
            
            helper(root.left, pathsum, path, targetsum)
            
            helper(root.right, pathsum, path, targetsum)
            
            path.pop(-1)
            

            return result

        result = []
        return helper(root, 0, [], targetSum)

        