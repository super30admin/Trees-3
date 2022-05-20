#time complexity: O(n)
#Space complexity: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res=[]
    count=0
    def pathSum(self, root, targetSum: int):
        self.res=[]
        self.helper(root,[],0,targetSum)
        return self.res
    def helper(self,root,path,currentSum,targetSum):
        if root== None:
            return
        path.append(root.val)
        if root.left==None and root.right==None and currentSum+root.val==targetSum:
            self.res.append(path.copy())
        self.helper(root.left,path,currentSum + root.val,targetSum)
        self.helper(root.right,path,currentSum + root.val,targetSum)
        path.pop()