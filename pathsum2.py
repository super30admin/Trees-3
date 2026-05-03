# O(h) time, O(h) space
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root,targetSum,0,[])
        return self.result
    
    def helper(self,root,targetSum,currSum,path):
        if root is None:
            return
        
        currSum += root.val
        path.append(root.val)

        if root.left is None and root.right is None:
            if currSum == targetSum:
                # We append a copy of the path using list() 
                # so it doesn't change when we pop later
                self.result.append(list(path))
        
        self.helper(root.left,targetSum,currSum,path)
        self.helper(root.right, targetSum, currSum,path)
        path.pop()