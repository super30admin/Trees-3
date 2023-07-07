# Time complexity : O(n), number of nodes
# Space complexity : O(H), Height of the tree
# The code ran on Leetcode

# Maintain path traversed until now and the sum accumulated. If a node is the leaf node, calculate its sum and append it to the result if the sum mathces the target

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        def helper(root, path, res, curSum, targetSum):
            # print(path)
            # Base case
            if not root:
                return

            # Logic
            path.append(root.val)
            if root.left == None and root.right == None and curSum + root.val == targetSum: 
                res.append(list(path))
                   
            helper(root.left, path, res, curSum + root.val, targetSum)
            
            helper(root.right, path, res, curSum + root.val, targetSum)
            # Backtrack
            path.pop()

        helper(root, [], res, 0, targetSum)
        return res