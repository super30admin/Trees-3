# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=[]
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root==None :return []
        self.helper(root,0,targetSum,[])
        return self.result
    def helper(self,root,currsum,targetSum,path) -> list:
        if(root==None):
            return
        currsum=currsum+root.val
        path.append(root.val)
        if(root.left==None and root.right==None):
            if(currsum==targetSum):
                self.result.append([i for i in path])
        self.helper(root.left,currsum,targetSum,path)
        self.helper(root.right,currsum,targetSum,path)
        path.pop()