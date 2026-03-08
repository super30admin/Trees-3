# problem 1 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def helper(self,root,targetSum,curr_sum,curr_arr):
        if not root:
            return
        curr_sum += root.val
        curr_arr.append(root.val)
        if root.left is None and root.right is None:
            if curr_sum == targetSum:
                self.sum_arr.append(list(curr_arr))
        self.helper(root.left,targetSum,curr_sum,curr_arr)
        self.helper(root.right,targetSum,curr_sum,curr_arr)
        curr_arr.pop()

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.sum_arr = []
        self.helper(root,targetSum,0,[])
        return self.sum_arr