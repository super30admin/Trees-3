# Time Complexity - O(n)
# Space Complexity - O(h)
#Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        path = []
        pathSum = 0
        def helper(root):
            nonlocal result
            nonlocal path
            nonlocal pathSum
            nonlocal targetSum
            if root is None:
                return 
            pathSum += root.val
            path.append(root.val)
            
            if root.left is None and root.right is None and targetSum == pathSum:
                result.append(path[:])
            
            helper(root.left)
            helper(root.right)
            
            path.pop()
            pathSum -= root.val
        
        helper(root)
        return result