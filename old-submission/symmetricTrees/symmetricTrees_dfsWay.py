'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(h) -- recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def dfsWay(self,nodeLft,nodeRt):
        
        # base-case
        if nodeLft == None and nodeRt == None:
            return True
    
        # logic-case
        elif nodeLft != None and nodeRt != None:
            if nodeLft.val == nodeRt.val:
                # check lft.lft and rt.rt pair
                lftRtr = self.dfsWay(nodeLft.left, nodeRt.right)

                if lftRtr == False: 
                    return lftRtr

                # check lft.rt and rt.lft
                rtRtr = self.dfsWay(nodeLft.right, nodeRt.left)

                return rtRtr        
            
            else:
                return False
        
        # base-case
        else:
            return False
        
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        return self.dfsWay(root.left,root.right)