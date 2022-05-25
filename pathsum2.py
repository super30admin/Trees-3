#Time Complexity: O(n)
#Space Complexity: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root,0,[],targetSum)
        return self.result
    def helper(self,root,currSum,path,targetSum):
        if root == None:
            return
        path.append(root.val)
        if root.left == None and root.right == None:
            
            if currSum + root.val == targetSum:
                
                self.result.append(path.copy())
        # path.append(root.val)
        self.helper(root.left,currSum+root.val,path,targetSum)
        self.helper(root.right,currSum+root.val,path, targetSum)
        path.pop()
        
        