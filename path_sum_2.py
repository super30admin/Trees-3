# // Time Complexity : O(n) where n is the number of nodes in the tree
# // Space Complexity : O(h) where h is the height of the tree 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.res = []  
    
    
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.helper(root, [], targetSum)
        return self.res
    
    
    def helper(self, root, temp, val):
        if not root:
            return
        
        temp.append(root.val)
        if not root.left and not root.right and val - root.val == 0:
            self.res.append(list(temp))
            temp.pop()
            return
        
        self.helper(root.left,temp,val-root.val)
        self.helper(root.right,temp,val-root.val)
        
        temp.pop()
        return
        
      