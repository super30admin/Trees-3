# Definition for a binary tree node.
# SC : O(N)
# TC : O(N) worse case, or else height of tree

import copy
from pip import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        
        def traversor(root, current_array ):
            temp = copy.deepcopy(current_array)
            if root == None:
                return None
            #print(root.val)
            
            if root.left == None and root.right==None:
                if sum(temp ) + root.val== targetSum:
                    temp.append(root.val)
                    self.res.append(temp)
                return
            
            temp.append(root.val)
            print(temp)
            traversor(root.left, temp)
            traversor(root.right, temp)
            
            
        
        traversor(root, [])
        
        return self.res
    
        
        
        