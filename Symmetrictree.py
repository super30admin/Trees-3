#Time: O(n)
#Space: O(h) 



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        #base
        if(root == None):
            return True 

        
        return self.dfs(root.left, root.right)
    
    def dfs(self, node1, node2):
        
          #this is for retruning the traversal to the node that called it. 
        if(node1== None and node2 == None):
            return True
        if(node1 == None or node2 == None or node1.val != node2.val):
            return False
      
        return self.dfs(node1.right, node2.left) and self.dfs(node1.left, node2.right)
