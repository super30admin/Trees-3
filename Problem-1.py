# Approach
# Find the path sum we need to add the path. add the pop into the stack after processing the sum of childs remove the path sum from the stack
# if target sum is reached just add the pathh stack copy to result

#Complexities
#Time O(N)
#Space O(n)




# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional, List


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        path = []
        currSum=0
        self.helper(root,targetSum,result,path,currSum)
        return result

    def helper(self,root,targetSum,result,path,currSum):
        if root == None:
            return
        currSum+=root.val
        path.append(root.val)

        if root.left==None and root.right==None:
            if currSum == targetSum:
                result.append(path.copy())
        self.helper(root.left,targetSum,result,path,currSum)
        self.helper(root.right,targetSum,result,path,currSum)
        path.pop(-1)

