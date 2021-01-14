# // Time Complexity : O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=[]
    target=0
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if(root==None):
            return []
        self.target=sum
        self.result=[]
        path=[]
        self.helper(root,0,path)
        return self.result
    
    def helper(self, root: TreeNode, cursum: int,path):
        if(root==None):
            return
        cursum+=root.val
        path.append(root.val)
        if(root.left==None and root.right==None ):
            newpath=[]
            newpath=newpath+path
            if(cursum==self.target):
                self.result.append(newpath)
        self.helper(root.left,cursum,path)
        self.helper(root.right,cursum,path)
        
        path.pop()