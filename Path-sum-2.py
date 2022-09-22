# TC : O(n)
# SC : O(height) - recursive stack and path
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        self.target = targetSum
        self.result = []
        self.traversal(root,0,[])
        return self.result
    
    def traversal(self,root,currsum,path):
        #base
        if root==None:
            return
        path.append(root.val)    
        currsum+=root.val
        
        self.traversal(root.left,currsum,path)
        
        if root.left == None and root.right==None:
            #print(currsum)
            if currsum == self.target:
                temp = path[:]  #make a copy , because DS in a DS is a pointer
                self.result.append(temp)        
                 
        self.traversal(root.right,currsum,path)
        
        path.pop() # pop to get back the last state