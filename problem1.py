# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(n + h*2^h)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        cur_path = []

        def search(root, cur_sum):
            if not root:
                return
            if not root.left and not root.right and cur_sum + root.val == targetSum:
                cur_path.append(root.val)
                res.append(cur_path[::])
                cur_path.pop()
                return
            
            cur_path.append(root.val)
            search(root.left, cur_sum + root.val)
            search(root.right, cur_sum + root.val)
            cur_path.pop()
        
        search(root, 0)
        return res