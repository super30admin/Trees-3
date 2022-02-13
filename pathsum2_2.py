#time-n,space-h
import copy
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result=[]
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root,[],0,targetSum)
        return self.result
    def helper(self,root,path,s,targetSum):
        #base
        if root is None:
            
            return
                
        #logic
        path.append(root.val)
        s=s+root.val
        self.helper(root.left,path,s,targetSum)
        if s==targetSum and root.left is None and root.right is None:
                temp=copy.copy(path)
                self.result.append(temp)
        self.helper(root.right,path,s,targetSum)
        path.pop()