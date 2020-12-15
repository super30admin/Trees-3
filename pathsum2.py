# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        self.res=[]
        self.sum=sum
        if not root:
            return 
        def dfs(root,curpath,sumi):
            if not root:
                return
            sumi+=root.val
            #if leaf node and found target sum>>>add to res
            if sumi==self.sum and not root.left and not root.right:
                self.res.append(curpath)
            if root.left:dfs(root.left,curpath+[root.left.val],sumi) 
            if root.right:dfs(root.right,curpath+[root.right.val],sumi)
       
            
        dfs(root,[root.val],0)
        return self.res
#O(N)
#O(N)





     
        
        
