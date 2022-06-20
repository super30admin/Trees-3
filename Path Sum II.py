# time complexity is o(n), where n is the size of the input
# space complexity is o(h), h = log(n), where n is the size of the input
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = list()
        self.psum(root, [], 0, targetSum, res)
        return res
    def psum(self, root, currl, currsum, targetSum, res):
        if(not root):
            return
        currl.append(root.val)
        self.psum(root.left, currl, currsum + root.val, targetSum, res)
        if(root and not root.left and not root.right):
            if(targetSum - currsum == root.val):
                res.append(currl.copy()) 
        self.psum(root.right, currl, currsum + root.val, targetSum, res)   
        currl.pop()
        