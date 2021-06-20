# Time Complexity : O(N) 
# Space Complexity :    O(H)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if root==None:
            return []
        self.result = []
        self.target = targetSum
        self.helper(root,0,[])
        return self.result

    def helper(self,root,currSum,curPath):
        if root==None:
            return
        
        currSum+=root.val
        curPath.append(root.val)

        if root.left==None and root.right==None and currSum==self.target:
            self.result.append(list(curPath))
        
        self.helper(root.left,currSum,curPath)
        self.helper(root.right,currSum,curPath)

        #backtrack 
        curPath.pop()