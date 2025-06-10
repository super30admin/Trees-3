# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Space Complexity - o(1)
# Time Complexity - o(n)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        

        def helper(node, curr_sum, li, target):
            if not node:
                return
            
            curr_sum+=node.val
            li.append(node.val)
            if not node.left and not node.right and curr_sum == target:
                l = li[:]
                res.append(l)
            
            helper(node.left,curr_sum, li, target)
            helper(node.right,curr_sum, li, target)
            li.pop()

        helper(root,0,[],targetSum)
        return res
