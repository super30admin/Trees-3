# Time Complexity - O(N)
# Space Complexity - O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root, targetSum, [])
        return self.result
    
    def helper(self, root, targetSum, path):
        if root == None:
            return

        path.append(root.val)

        if targetSum - root.val == 0 and root.left == None and root.right == None:
            self.result.append(path[:])
            path.pop()
            return
        
        # recurse
        self.helper(root.left, targetSum-root.val, path)
        self.helper(root.right, targetSum-root.val, path)

        #backtrack
        path.pop()
        