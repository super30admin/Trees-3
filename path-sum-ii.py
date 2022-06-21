# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result=[]
        self.helper(root,0,[],targetSum)
        return self.result
    def helper(self,root: Optional[TreeNode], currSum: int, path: List[int], targetSum:int):
        if root==None: return
        currSum+=root.val
        path.append(root.val)
        self.helper(root.left,currSum,path,targetSum)
        if root.left==None and root.right==None:
            if currSum==targetSum:
                # print(path)    
                self.result.append(path.copy())
        self.helper(root.right,currSum,path,targetSum)
        path.pop()